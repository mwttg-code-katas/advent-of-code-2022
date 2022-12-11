package io.github.mwttg.adventofcode.day11

import kotlin.system.measureTimeMillis

// unfortunately solution for part 2 was not my idea :'(
const val LCM = 19L * 3L * 13L * 7L * 5L * 11L * 17L * 2L

fun main() {
    val mostActive: Long
    val time1 = measureTimeMillis { mostActive = getMostActives(10000, true) }
    println("The Level of Monkey-Business after 20 rounds is'$mostActive'. This took $time1 ms.")

}

fun getMostActives(rounds: Int, ridiculousLevels: Boolean): Long {
    val monkeysByIndex = createMonkeys().toMutableMap()
    for (round in 1..rounds) {
        Round.execute(monkeysByIndex, ridiculousLevels)
    }
    val sorted = monkeysByIndex.entries
        .sortedBy { it.value.inspectedItems }
        .reversed()

    return sorted[0].value.inspectedItems.toLong() * sorted[1].value.inspectedItems.toLong()
}

private fun createMonkeys() = mapOf(
    0 to Monkey(
        items = mutableListOf(85, 77, 77),
        operation = { old -> old * 7 },
        test = Triple(19, 6, 7),
    ),
    1 to Monkey(
        items = mutableListOf(80, 99),
        operation = { old -> old * 11 },
        test = Triple(3, 3, 5),
    ),
    2 to Monkey(
        items = mutableListOf(74, 60, 74, 63, 86, 92, 80),
        operation = { old -> old + 8 },
        test = Triple(13, 0, 6),
    ),
    3 to Monkey(
        items = mutableListOf(71, 58, 93, 65, 80, 68, 54, 71),
        operation = { old -> old + 7 },
        test = Triple(7, 2, 4),
    ),
    4 to Monkey(
        items = mutableListOf(97, 56, 79, 65, 58),
        operation = { old -> old + 5 },
        test = Triple(5, 2, 0),
    ),
    5 to Monkey(
        items = mutableListOf(77),
        operation = { old -> old + 4 },
        test = Triple(11, 4, 3),
    ),
    6 to Monkey(
        items = mutableListOf(99, 90, 84, 50),
        operation = { old -> old * old },
        test = Triple(17, 7, 1),
    ),
    7 to Monkey(
        items = mutableListOf(50, 66, 61, 92, 64, 78),
        operation = { old -> old + 3 },
        test = Triple(2, 5, 1),
    ),
)