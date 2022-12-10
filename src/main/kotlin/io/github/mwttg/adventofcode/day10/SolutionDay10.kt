package io.github.mwttg.adventofcode.day10

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day10/input.txt"
private const val SPACE = " "

private val CYCLES = setOf(20, 60, 100, 140, 180, 220)

fun main() {
    val signalStrength: Int
    val time1 = measureTimeMillis { signalStrength = getSignalStrength() }
    println("The Signal-Strength is '$signalStrength'. This took $time1 ms.")

    val time2 = measureTimeMillis { renderDisplay() }
    println("This took $time2 ms.")

}

fun getSignalStrength(): Int {
    val registerByCycle = programTimeline()
    return CYCLES.sumOf { registerByCycle[it]!! * it }
}

fun programTimeline() = File(FILENAME)
    .readLines()
    .map { it.split(SPACE) }
    .scan(listOf(Pair(1, 1))) { acc, item ->
        when (item[0]) {
            "addx" -> listOf(
                Pair(acc.last().first, acc.last().second + 1),
                Pair(acc.last().first + item[1].toInt(), acc.last().second + 2),
            )
            "noop" -> listOf(Pair(acc.last().first, acc.last().second + 1))
            else -> throw Exception("not possible")
        }
    }
    .flatten()
    .associate { Pair(it.second, it.first) }

fun renderDisplay() {
    val registerByCycle = programTimeline()
    for (row in 1..6) {
        for (column in 1..40) {
            val cycle = ((row - 1) * 40) + column
            val registerX = registerByCycle[cycle]
            if (registerX == column || registerX == column - 1 || registerX == column - 2) {
                print("█")
            } else {
                print(" ")
            }
        }
        println()
    }
}