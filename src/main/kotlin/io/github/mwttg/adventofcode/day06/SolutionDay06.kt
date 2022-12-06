package io.github.mwttg.adventofcode.day06

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day06/input.txt"

fun main() {
    val marker: Int
    val time1 = measureTimeMillis { marker = findMarkerIn(readFile()) }
    println("The first start-of-packet marker was found after '$marker' characters. This took $time1 ms.")
}

fun readFile() = File(FILENAME).readText()

fun findMarkerIn(input: String): Int {
    var uniqueIndex = 0
    val window = Window()
    for ((index, c) in input.withIndex()) {
        window.add(c)
        if (window.isUnique()) {
            uniqueIndex = index
            break
        }
    }
    return uniqueIndex + 1
}