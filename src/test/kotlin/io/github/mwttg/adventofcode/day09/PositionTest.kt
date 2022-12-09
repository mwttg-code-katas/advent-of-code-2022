package io.github.mwttg.adventofcode.day09

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactlyInAnyOrder
import strikt.assertions.isEqualTo

private val POSITION = Position(0, 0)

internal class PositionTest {

    @Test
    fun `move up from (0, 0)`() {
        val actual = POSITION.moveUp()
        expectThat(actual).isEqualTo(Position(0, 1))
    }

    @Test
    fun `move down from (0, 0)`() {
        val actual = POSITION.moveDown()
        expectThat(actual).isEqualTo(Position(0, -1))
    }

    @Test
    fun `move left from (0, 0)`() {
        val actual = POSITION.moveLeft()
        expectThat(actual).isEqualTo(Position(-1, 0))
    }

    @Test
    fun `move right from (0, 0)`() {
        val actual = POSITION.moveRight()
        expectThat(actual).isEqualTo(Position(1, 0))
    }

    @Test
    fun `get neighbours from (0, 0)`() {
        val actual = POSITION.neighbours()
        expectThat(actual)
            .containsExactlyInAnyOrder(
                Position(-1, 1),
                Position(0, 1),
                Position(1, 1),
                Position(-1, 0),
                Position(0, 0),
                Position(1, 0),
                Position(-1, -1),
                Position(0, -1),
                Position(1, -1),
            )
    }
}