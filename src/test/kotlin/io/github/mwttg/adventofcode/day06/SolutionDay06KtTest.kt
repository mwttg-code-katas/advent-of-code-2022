package io.github.mwttg.adventofcode.day06

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class SolutionDay06KtTest {

    @Test
    fun `bvwbjplbgvbhsrlpgdmjqwftvncz should be 5`() {
        expectThat(findMarkerIn("bvwbjplbgvbhsrlpgdmjqwftvncz"))
            .isEqualTo(5)
    }

    @Test
    fun `nppdvjthqldpwncqszvftbrmjlhg should be 6`() {
        expectThat(findMarkerIn("nppdvjthqldpwncqszvftbrmjlhg"))
            .isEqualTo(6)
    }

    @Test
    fun `nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg should be 10`() {
        expectThat(findMarkerIn("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
            .isEqualTo(10)
    }

    @Test
    fun `zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw should be 11`() {
        expectThat(findMarkerIn("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
            .isEqualTo(11)
    }
}