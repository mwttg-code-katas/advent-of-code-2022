package io.github.mwttg.adventofcode.day11

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class SolutionDay11KtTest {

    @Test
    fun `test example - 20 rounds (normal)`() {
        val monkeysByIndex = createMonkeys().toMutableMap()
        for (round in 1..20) {
            println("Round $round")
            Round.execute(monkeysByIndex, false)
            Round.print(monkeysByIndex)
        }
        val sorted = monkeysByIndex.entries
            .sortedBy { it.value.inspectedItems }
            .reversed()

        expectThat(sorted[0].value.inspectedItems * sorted[1].value.inspectedItems).isEqualTo(10605)
    }

    private fun createMonkeys() = mapOf(
        0 to Monkey(
            items = mutableListOf(79, 98),
            operation = { old -> old * 19 },
            test = Triple(23, 2, 3),
        ),
        1 to Monkey(
            items = mutableListOf(54, 65, 75, 74),
            operation = { old -> old + 6 },
            test = Triple(19, 2, 0),
        ),
        2 to Monkey(
            items = mutableListOf(79, 60, 97),
            operation = { old -> old * old },
            test = Triple(13, 1, 3),
        ),
        3 to Monkey(
            items = mutableListOf(74),
            operation = { old -> old + 3 },
            test = Triple(17, 0, 1),
        ),
    )
}