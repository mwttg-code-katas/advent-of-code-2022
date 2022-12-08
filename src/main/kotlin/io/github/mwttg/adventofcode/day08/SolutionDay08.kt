package io.github.mwttg.adventofcode.day08

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day08/input.txt"

fun main() {
    val visibleTrees: Int
    val time1 = measureTimeMillis { visibleTrees = getVisibleTrees() }
    println("'$visibleTrees' are visible from outside the Grid. This took $time1 ms.")

    val maxScenicScore: Int
    val time2 = measureTimeMillis { maxScenicScore = getMaxScenicScore() }
    println("The max Scenic-Score is '$maxScenicScore'. This took $time2 ms.")
}

// I've a feeling that there is a 'better' solution with less code :/
fun getVisibleTrees(): Int {
    val treeHeights = readTreeHeights()
    val grid = Grid(treeHeights)
    MarkTrees.markVisibleTrees(grid)
    return grid.getSumOfVisibleTrees()
}

fun readTreeHeights() = File(FILENAME)
    .readLines()
    .map { line ->
        line.map { number ->
            number.toString().toInt()
        }
    }

fun getMaxScenicScore(): Int {
    val treeHeights = readTreeHeights()
    val grid = Grid(treeHeights)
    return grid.getMaxScenicScore()
}