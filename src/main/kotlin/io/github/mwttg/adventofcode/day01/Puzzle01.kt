package io.github.mwttg.adventofcode.day01

import io.github.mwttg.adventofcode.utils.TextFile
import kotlin.system.measureTimeMillis

fun main() {
    var maxCalories: Int
    val time = measureTimeMillis { maxCalories = solvePuzzle01() }
    println("Most calories carried by an Elf is $maxCalories. This took $time ms.")
}

fun solvePuzzle01() = TextFile.readFromResources("day01/input.txt")
    .foldIndexed(mutableListOf(mutableListOf<Int>())) { _, acc, item ->
        if (item == "") {
            acc.add(mutableListOf())
        } else {
            acc.last().add(item.toInt())
        }
        acc
    }.maxOf { listOfCalories -> listOfCalories.sum() }