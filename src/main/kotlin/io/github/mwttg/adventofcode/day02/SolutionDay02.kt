package io.github.mwttg.adventofcode.day02

import java.io.File
import kotlin.system.measureTimeMillis

private const val SPACE = " "
private const val FILENAME = "./puzzle-inputs/day02/input.txt"

fun main() {
    val score1: Int
    val time1 = measureTimeMillis { score1 = getScore1() }
    println("Your total score is '$score1' points. This took $time1 ms.")

    val score2: Int
    val time2 = measureTimeMillis { score2 = getScore2() }
    println("Your total score is '$score2' points. This took $time2 ms.")
}

private fun getScore1() = File(FILENAME)
    .readLines()
    .map { it.split(SPACE) }
    .map { Pair(Shape.createFromSymbol(it[0]), Shape.createFrom(it[1])) }
    .sumOf { it.second.getScore(it.first) }

private fun getScore2() = File(FILENAME)
    .readLines()
    .map { it.split(SPACE) }
    .map { Pair(Shape.createFromSymbol(it[0]), Result.createFromSymbol(it[1])) }
    .map { Pair(it.first, it.first.getHand(it.second)) }
    .sumOf { it.second.getScore(it.first) }
