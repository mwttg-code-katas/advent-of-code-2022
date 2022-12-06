package io.github.mwttg.adventofcode.day06

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class SolutionDay06KtTest {

    @Test
    fun `bvwbjplbgvbhsrlpgdmjqwftvncz should be 5`() {
        expectThat(findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", PACKET_WINDOW_SIZE))
            .isEqualTo(5)
        expectThat(findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", MESSAGE_WINDOW_SIZE))
            .isEqualTo(23)
    }

    @Test
    fun `nppdvjthqldpwncqszvftbrmjlhg should be 6`() {
        expectThat(findMarker("nppdvjthqldpwncqszvftbrmjlhg", PACKET_WINDOW_SIZE))
            .isEqualTo(6)
        expectThat(findMarker("nppdvjthqldpwncqszvftbrmjlhg", MESSAGE_WINDOW_SIZE))
            .isEqualTo(23)
    }

    @Test
    fun `nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg should be 10`() {
        expectThat(findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", PACKET_WINDOW_SIZE))
            .isEqualTo(10)
        expectThat(findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", MESSAGE_WINDOW_SIZE))
            .isEqualTo(29)
    }

    @Test
    fun `zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw should be 11`() {
        expectThat(findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", PACKET_WINDOW_SIZE))
            .isEqualTo(11)
        expectThat(findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", MESSAGE_WINDOW_SIZE))
            .isEqualTo(26)
    }
}