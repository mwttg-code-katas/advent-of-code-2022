package io.github.mwttg.adventofcode.day01

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day01/input.txt"

fun main() {
    val max: Int
    val time1 = measureTimeMillis { max = getMaxCalories() }
    println("Most calories carried by an Elf is $max. This took $time1 ms.")

    val combined: Int
    val time2 = measureTimeMillis { combined = getCombinedCalories() }
    println("The combined Calories amount of the top three Elves is $combined. This took $time2 ms.")
}

fun getMaxCalories() = File(FILENAME)
    .readLines()
    .fold(mutableListOf(mutableListOf<Int>())) { acc, item ->
        if (item.isBlank()) acc.add(mutableListOf()) else acc.last().add(item.toInt())
        acc
    }
    .maxOf { it.sum() }

fun getCombinedCalories() = File(FILENAME)
    .readLines()
    .fold(mutableListOf(mutableListOf<Int>())) { acc, item ->
        if (item.isBlank()) acc.add(mutableListOf()) else acc.last().add(item.toInt())
        acc
    }
    .map { it.sum() }
    .sortedDescending()
    .take(3)
    .sum()