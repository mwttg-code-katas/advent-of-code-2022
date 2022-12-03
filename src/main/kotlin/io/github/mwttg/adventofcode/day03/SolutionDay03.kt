package io.github.mwttg.adventofcode.day03

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day03/input.txt"

fun main() {
    val prioritySum: Int
    val time1 = measureTimeMillis { prioritySum = getSumOfPriorities() }
    println("The sum of the priority of misplaced items is '$prioritySum'. This took $time1 ms.")
}

fun getSumOfPriorities() = File(FILENAME)
    .readLines()
    .map { Rucksack.createFrom(it) }
    .sumOf { it.getPriorityOfMisplacedItem() }