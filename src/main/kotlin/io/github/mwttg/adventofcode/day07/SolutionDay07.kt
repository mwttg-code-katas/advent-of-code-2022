package io.github.mwttg.adventofcode.day07

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day07/input.txt"

private val IS_FILE = "(\\d+) (.+)".toRegex()
private val DIR_COMMAND = "\\$ cd (.+)".toRegex()

fun main() {
    val size: Int
    val time1 = measureTimeMillis { size = getSumOfMost100000() }
    println("The sum of directories < 100000 is '$size'. This took $time1 ms.")

    val size2: Int
    val time2 = measureTimeMillis {
        val structure = getFolderSizes()
        val needed = 30000000 - (70000000 - structure["root"]!!)
        size2 = getSmallestDirForDelete(needed, structure)
        println()
    }
    println("The total size of the smallest directory to delete is '$size2'. This took $time2 ms.")
}

fun getSumOfMost100000() = getFolderSizes()
    .map { it.value }
    .filter { it < 100000 }
    .sum()

fun getSmallestDirForDelete(sizeNeeded: Int, dirStructure: Map<String, Int>) = dirStructure
    .map { Pair(it.value, it.key) }
    .toMap()
    .filter { it.key > sizeNeeded }
    .toList()
    .sortedBy { it.first }[0].first

fun getFolderSizes() = File(FILENAME)
    .readLines()
    .filter { DIR_COMMAND.matches(it) || IS_FILE.matches(it) }
    .fold(Pair("root", mutableMapOf<String, Int>())) { acc, item ->
        var currentDir = acc.first

        if (DIR_COMMAND.matches(item)) {
            DIR_COMMAND.find(item)
                .let { match ->
                    currentDir = when (val d = match!!.destructured.component1()) {
                        ".." -> currentDir.exit()
                        "/" -> "root"
                        else -> currentDir.enter(d)
                    }
                }
        }

        val currentSize = acc.second.getOrDefault(currentDir, 0)
        if (IS_FILE.matches(item)) {
            IS_FILE.find(item)
                .let { match ->
                    val size = match!!.destructured.component1().toInt()
                    acc.second.put(currentDir, currentSize + size)

                    addUp(acc.second, currentDir, size)
                }
        }

        Pair(currentDir, acc.second)
    }
    .second

fun addUp(dirSizes: MutableMap<String, Int>, currentDir: String, currentSize: Int) {
    var dir = currentDir
    while (dir != "root") {
        dir = dir.substring(0, dir.indexOfLast { it == '/' })
        val s = dirSizes.getOrDefault(dir, 0)
        dirSizes[dir] = s + currentSize
    }
}

fun String.enter(dir: String) = "$this/$dir"

fun String.exit() = this.substring(0, this.indexOfLast { it == '/' })