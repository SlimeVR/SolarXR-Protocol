package dev.slimevr.fbscodegen

import com.squareup.kotlinpoet.FileSpec
import java.io.File

private data class CodegenArgs(
    val outputDir: File,
    val includeDirs: List<File>,
    val entryFile: File,
)

/**
 * CLI usage:
 *   flatbuffers-codegen -o <output-dir> [-I <include-dir>]... <entry.fbs>
 *
 * Include directives in .fbs files are resolved against the provided -I directories
 * (and the directory of the file that contains the include). All reachable schemas
 * are collected transitively, deduplicated, and generated in dependency order.
 */
fun main(args: Array<String>) {
    val parsed = parseArgs(args)
    if (parsed == null) {
        System.err.println("Usage: flatbuffers-codegen -o <output-dir> [-I <include-dir>]... <entry.fbs>")
        System.exit(1)
        return
    }

    val resolvedOutputDir = parsed.outputDir
    val resolvedEntryFile = parsed.entryFile

    require(resolvedEntryFile.exists()) { "Entry file not found: $resolvedEntryFile" }
    resolvedOutputDir.deleteRecursively()
    resolvedOutputDir.mkdirs()

    // Add the entry file's own directory as an implicit include dir
    val includeDirs = parsed.includeDirs.toMutableList()
    resolvedEntryFile.parentFile?.let { includeDirs += it }

    val schemas = resolveIncludes(resolvedEntryFile, includeDirs, linkedSetOf())
    val fileSpecs = Generator(schemas).generate()
    writeGeneratedFiles(resolvedOutputDir, fileSpecs)
    println("Done. ${fileSpecs.size} file(s) generated.")
}

private fun parseArgs(args: Array<String>): CodegenArgs? {
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

    if (outputDir == null || entryFile == null) return null
    return CodegenArgs(outputDir, includeDirs, entryFile)
}

private fun writeGeneratedFiles(outputDir: File, fileSpecs: List<FileSpec>) {
    fileSpecs.forEach { spec ->
        // A schema without a namespace has an empty package, and "$packagePath/Name.kt"
        // would then be rooted, making resolve() escape the output dir entirely.
        val outFile = spec.packageName
            .replace('.', '/')
            .split('/')
            .filter { it.isNotEmpty() }
            .fold(outputDir) { dir, segment -> dir.resolve(segment) }
            .resolve("${spec.name}.kt")
        outFile.parentFile.mkdirs()
        outFile.writeText(spec.toString())
        println("Wrote ${outFile.toRelativeString(outputDir)}")
    }
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
): List<Schema> {
    val canonical = file.canonicalPath
    if (canonical in visited) return emptyList()
    visited += canonical

    println("Parsing ${file.name} ...")
    val schema = Parser(file.readText()).parse().copy(fileName = file.nameWithoutExtension)

    val results = mutableListOf<Schema>()

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
