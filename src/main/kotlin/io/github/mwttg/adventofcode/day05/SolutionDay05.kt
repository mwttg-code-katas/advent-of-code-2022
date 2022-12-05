package io.github.mwttg.adventofcode.day05

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day05/input.txt"
private const val SPACE = " "

private fun init() = mapOf(
    Pair(1, mutableListOf('R', 'S', 'L', 'F', 'Q')),
    Pair(2, mutableListOf('N', 'Z', 'Q', 'G', 'P', 'T')),
    Pair(3, mutableListOf('S', 'M', 'Q', 'B')),
    Pair(4, mutableListOf('T', 'G', 'Z', 'J', 'H', 'C', 'B', 'Q')),
    Pair(5, mutableListOf('P', 'H', 'M', 'B', 'N', 'F', 'S')),
    Pair(6, mutableListOf('P', 'C', 'Q', 'N', 'S', 'L', 'V', 'G')),
    Pair(7, mutableListOf('W', 'C', 'F')),
    Pair(8, mutableListOf('Q', 'H', 'G', 'Z', 'W', 'V', 'P', 'M')),
    Pair(9, mutableListOf('G', 'Z', 'D', 'L', 'C', 'N', 'R')),
)

fun main() {
    val start1 = init()
    val crates: String
    val time1 = measureTimeMillis { crates = getTopOfStacks(false, start1) }
    println("The crates on top of each stack are '$crates'. This took $time1 ms.")

    val start2 = init()
    val crates2: String
    val time2 = measureTimeMillis { crates2 = getTopOfStacks(true, start2) }
    println("The crates on top of each stack are '$crates2'. This took $time2 ms.")
}

private fun getTopOfStacks(is9001: Boolean, stackOfCrates: Map<Int, MutableList<Char>>) =
    File(FILENAME)
        .readLines()
        .map {
            val splits = it.split(SPACE)
            Triple(splits[1].toInt(), splits[3].toInt(), splits[5].toInt())
        }
        .map {
            val amount = it.first
            val from = it.second
            val to = it.third
            val onCrane = stackOfCrates[from]!!.takeLast(amount)
            val reallyOnCrane = if (is9001) onCrane else onCrane.reversed()
            repeat(amount) { stackOfCrates[from]!!.removeLast() }
            stackOfCrates[to]!!.addAll(reallyOnCrane)
        }
        .run {
            stackOfCrates.keys.sorted().map {
                stackOfCrates[it]!!.last()
            }
        }
        .toString()