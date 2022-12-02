package io.github.mwttg.adventofcode.day02

import java.io.File
import kotlin.system.measureTimeMillis

private const val SPACE = " "

fun main() {
    val score: Int
    val time1 = measureTimeMillis { score = getScore() }
    println("Your total score is '$score' points. This took $time1 ms.")
}

private fun getScore() =
    File("./puzzle-inputs/day02/input.txt")
        .readLines()
        .map { it.split(SPACE) }
        .map { Pair(Shape.createFromSymbol(it[0]), Shape.createFrom(it[1])) }
        .sumOf { it.second.getScore(it.first) }
