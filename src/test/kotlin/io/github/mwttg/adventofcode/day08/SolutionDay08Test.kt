package io.github.mwttg.adventofcode.day08

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

private val TREE_HEIGHTS = listOf(
    listOf(3, 0, 3, 7, 3),
    listOf(2, 5, 5, 1, 2),
    listOf(6, 5, 3, 3, 2),
    listOf(3, 3, 5, 4, 9),
    listOf(3, 5, 3, 9, 0)
)

internal class SolutionDay08Test {

    @Test
    fun `test example`() {
        val grid = Grid(TREE_HEIGHTS)
        val actual = CountTrees.countVisibleTrees(grid)
        expectThat(actual).isEqualTo(21)
    }
}
