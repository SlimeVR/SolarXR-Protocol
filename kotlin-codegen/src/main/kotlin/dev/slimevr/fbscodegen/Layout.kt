package dev.slimevr.fbscodegen

internal fun alignTo(value: Int, alignment: Int): Int =
    ((value + alignment - 1) / alignment) * alignment

internal fun snakeToCamel(name: String): String =
    name.split('_').mapIndexed { index, part ->
        if (index == 0) part.lowercase() else part.replaceFirstChar { it.uppercase() }
    }.joinToString("")
