package io.github.mwttg.adventofcode.day03

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day03/input.txt"

fun main() {
    val prioritySum: Int
    val time1 = measureTimeMillis { prioritySum = getSumOfPriorities() }
    println("The sum of the priority of misplaced items is '$prioritySum'. This took $time1 ms.")

    val badgeSum: Int
    val time2 = measureTimeMillis { badgeSum = getSumOfBadgePriorities() }
    println("The sum of the priority of the badges is '$badgeSum'. This took $time2 ms.")
}

fun getSumOfPriorities() = File(FILENAME)
    .readLines()
    .map { Rucksack.createFrom(it) }
    .sumOf { it.getPriorityOfMisplacedItem() }

fun getSumOfBadgePriorities() = File(FILENAME)
    .readLines()
    .chunked(3)
    .map {
        it.run {
            this[0].toSet().intersect(this[1].toSet()).intersect(this[2].toSet()).elementAt(0)
        }
    }
    .sumOf { Rucksack.getPriorityOf(it) }