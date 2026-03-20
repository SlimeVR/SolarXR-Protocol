package dev.slimevr.fbscodegen

import java.io.File

/**
 * CLI usage:
 *   flatbuffers-codegen -o <output-dir> [-I <include-dir>]... <entry.fbs>
 *
 * Include directives in .fbs files are resolved against the provided -I directories
 * (and the directory of the file that contains the include). All reachable schemas
 * are collected transitively, deduplicated, and generated in dependency order.
 */
fun main(args: Array<String>) {
    var outputDir: File? = null
    val includeDirs = mutableListOf<File>()
    var entryFile: File? = null

    var i = 0
    while (i < args.size) {
        when (args[i]) {
            "-o" -> { outputDir = File(args[++i]) }
            "-I" -> { includeDirs += File(args[++i]) }
            else -> {
                if (entryFile != null) {
                    System.err.println("Only one entry .fbs file is supported.")
                    System.exit(1)
                }
                entryFile = File(args[i])
            }
        }
        i++
    }

    if (outputDir == null || entryFile == null) {
        System.err.println("Usage: flatbuffers-codegen -o <output-dir> [-I <include-dir>]... <entry.fbs>")
        System.exit(1)
    }

    require(entryFile!!.exists()) { "Entry file not found: $entryFile" }

    // Add the entry file's own directory as an implicit include dir
    entryFile!!.parentFile?.let { includeDirs += it }

    val schemas = resolveIncludes(entryFile!!, includeDirs, linkedSetOf())

    val generator = KotlinGenerator(schemas)
    val fileSpecs = generator.generate()

    fileSpecs.forEach { spec ->
        val content = spec.toString().lines().joinToString("\n") { line ->
            val stripped = line.trimStart()
            if (stripped.startsWith("public "))
                line.substring(0, line.length - stripped.length) + stripped.removePrefix("public ")
            else line
        }
        val packagePath = spec.packageName.replace('.', '/')
        val outFile = outputDir!!.resolve("$packagePath/${spec.name}.kt")
        outFile.parentFile.mkdirs()
        outFile.writeText(content)
        println("Wrote ${spec.packageName}/${spec.name}.kt")
    }

    println("Done. ${fileSpecs.size} file(s) generated.")
}

/**
 * Recursively resolves and parses .fbs files starting from [file].
 * Returns schemas in dependency order (dependencies before dependents).
 * [visited] tracks canonical paths already processed to avoid cycles/duplicates.
 */
private fun resolveIncludes(
    file: File,
    includeDirs: List<File>,
    visited: LinkedHashSet<String>,
): List<FbsSchema> {
    val canonical = file.canonicalPath
    if (canonical in visited) return emptyList()
    visited += canonical

    println("Parsing ${file.name} ...")
    val schema = FbsParser(file.readText()).parse().copy(fileName = file.nameWithoutExtension)

    val results = mutableListOf<FbsSchema>()

    // Resolve each include before adding this schema (dependencies first)
    schema.includes.forEach { includePath ->
        val resolved = resolveIncludePath(includePath, file.parentFile, includeDirs)
            ?: error("Cannot resolve include \"$includePath\" from ${file.name} (searched: ${(listOf(file.parentFile) + includeDirs).map { it.path }})")
        results += resolveIncludes(resolved, includeDirs, visited)
    }

    results += schema
    return results
}

private fun resolveIncludePath(
    includePath: String,
    fileDir: File?,
    includeDirs: List<File>,
): File? {
    // Try relative to the file's own directory first, then each -I directory
    val searchDirs = listOfNotNull(fileDir) + includeDirs
    return searchDirs.map { File(it, includePath) }.firstOrNull { it.exists() }
}