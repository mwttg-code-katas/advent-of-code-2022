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
}

fun getSignalStrength(): Int {
    val registerByCycle = programTimeline()
    return CYCLES.sumOf {
        val cycle = if (registerByCycle.containsKey(it)) it else it - 1
        val registerX = registerByCycle[cycle]!!
        it * registerX
    }
}

fun programTimeline() = File(FILENAME)
    .readLines()
    .map { it.split(SPACE) }
    .scan(Pair(1, 1)) { acc, item ->
        when (item[0]) {
            "addx" -> Pair(acc.first + item[1].toInt(), acc.second + 2)
            "noop" -> Pair(acc.first, acc.second + 1)
            else -> throw Exception("not possible")
        }
    }
    .associate { Pair(it.second, it.first) }
