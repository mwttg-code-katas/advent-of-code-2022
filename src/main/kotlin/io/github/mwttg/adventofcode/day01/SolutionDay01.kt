package io.github.mwttg.adventofcode.day01

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day01/input.txt"

fun main() {
    var maxCalories: Int
    val timePuzzle1 = measureTimeMillis { maxCalories = solvePuzzle01() }
    println("Most calories carried by an Elf is $maxCalories. This took $timePuzzle1 ms.")

    var combinedCalories: Int
    val timePuzzle2 = measureTimeMillis {
        combinedCalories = solvePuzzle02().take(3).sum()
    }
    println("The combined Calories amount of the top three Elves is $combinedCalories. This took $timePuzzle2 ms.")
}

fun solvePuzzle01() = File(FILENAME)
    .readLines()
    .foldIndexed(mutableListOf(mutableListOf<Int>())) { _, acc, item ->
        if (item.isBlank()) acc.add(mutableListOf()) else acc.last().add(item.toInt())
        acc
    }
    .maxOf { listOfCalories -> listOfCalories.sum() }

fun solvePuzzle02() = File(FILENAME)
    .readLines()
    .foldIndexed(mutableListOf(mutableListOf<Int>())) { _, acc, item ->
        if (item.isBlank()) acc.add(mutableListOf()) else acc.last().add(item.toInt())
        acc
    }
    .map { listOfCalories -> listOfCalories.sum() }
    .sortedDescending()