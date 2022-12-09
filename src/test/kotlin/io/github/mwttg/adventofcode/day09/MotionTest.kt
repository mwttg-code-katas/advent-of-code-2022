package io.github.mwttg.adventofcode.day09

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class MotionTest {

    @Test
    fun `create Motion up`() {
        expectThat(Motion.create("U 3")).isEqualTo(Motion(Direction.UP, 3))
    }

    @Test
    fun `create Motion down`() {
        expectThat(Motion.create("D 2")).isEqualTo(Motion(Direction.DOWN, 2))
    }

    @Test
    fun `create Motion left`() {
        expectThat(Motion.create("L 5")).isEqualTo(Motion(Direction.LEFT, 5))
    }

    @Test
    fun `create Motion right`() {
        expectThat(Motion.create("R 1")).isEqualTo(Motion(Direction.RIGHT, 1))
    }

    @Test
    fun `create actions from 'D 3'`() {
        expectThat(Motion.create("D 3").createActions())
            .isEqualTo(
                listOf(
                    Direction.DOWN,
                    Direction.DOWN,
                    Direction.DOWN,
                )
            )
    }

    @Test
    fun `create actions from 'U 2'`() {
        expectThat(Motion.create("U 2").createActions())
            .isEqualTo(
                listOf(
                    Direction.UP,
                    Direction.UP,
                )
            )
    }
}