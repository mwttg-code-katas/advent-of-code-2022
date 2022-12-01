package io.github.mwttg.adventofcode.day01

import io.github.mwttg.adventofcode.utils.TextFile
import kotlin.system.measureTimeMillis

fun main() {
    var maxCalories: Int
    val timePuzzle1 = measureTimeMillis { maxCalories = solvePuzzle01() }
    println("Most calories carried by an Elf is $maxCalories. This took $timePuzzle1 ms.")

    var combinedCalories: Int
    val timePuzzle2 = measureTimeMillis {
        val sorted = solvePuzzle02()
        combinedCalories = sorted[0] + sorted[1] + sorted[2]
    }
    println("The combined Calories amount of the top three Elves is $combinedCalories. This took $timePuzzle2 ms.")

}

fun solvePuzzle01() = TextFile.readFromResources("day01/input.txt")
    .foldIndexed(mutableListOf(mutableListOf<Int>())) { _, acc, item ->
        if (item == "") {
            acc.add(mutableListOf())
        } else {
            acc.last().add(item.toInt())
        }
        acc
    }
    .maxOf { listOfCalories -> listOfCalories.sum() }

fun solvePuzzle02() = TextFile.readFromResources("day01/input.txt")
    .foldIndexed(mutableListOf(mutableListOf<Int>())) { _, acc, item ->
        if (item == "") {
            acc.add(mutableListOf())
        } else {
            acc.last().add(item.toInt())
        }
        acc
    }
    .map { listOfCalories -> listOfCalories.sum() }
    .sortedDescending()