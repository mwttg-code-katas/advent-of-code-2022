package io.github.mwttg.adventofcode.day04

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day04/input.txt"

fun main() {
    val fully: Int
    val time1 = measureTimeMillis { fully = getFullyContained() }
    println("The are '$fully' fully overlapped sections. This took $time1 ms.")

    val partial: Int
    val time2 = measureTimeMillis { partial = getOverlapped() }
    println("The are '$partial' partial overlapped sections. This took $time2 ms.")
}

fun getFullyContained() = File(FILENAME)
    .readLines()
    .map { Section.createFrom(it) }
    .map { it.first.overlapsComplete(it.second) }
    .count { it }

fun getOverlapped() = File(FILENAME)
    .readLines()
    .map { Section.createFrom(it) }
    .map { it.first.overlaps(it.second) }
    .count { it }