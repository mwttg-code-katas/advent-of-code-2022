package io.github.mwttg.adventofcode.day01

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val max: Int
    val time1 = measureTimeMillis { max = getMaxCalories() }
    println("Most calories carried by an Elf is $max. This took $time1 ms.")

    val combined: Int
    val time2 = measureTimeMillis { combined = getCombinedCalories() }
    println("The combined calories of the top three Elves is $combined. This took $time2 ms.")
}

private fun getMaxCalories() = getCaloriesPerElf().maxOf { it.sum() }

private fun getCombinedCalories() = getCaloriesPerElf()
    .map { it.sum() }
    .sortedDescending()
    .take(3)
    .sum()

private fun getCaloriesPerElf() = File("./puzzle-inputs/day01/input.txt")
    .readLines()
    .fold(mutableListOf(mutableListOf<Int>())) { acc, item ->
        if (item.isBlank()) acc.add(mutableListOf()) else acc.last().add(item.toInt())
        acc
    }