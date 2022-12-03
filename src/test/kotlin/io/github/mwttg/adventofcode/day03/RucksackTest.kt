package io.github.mwttg.adventofcode.day03

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class RucksackTest {

    @Test
    fun `check if rucksack is created correctly`() {
        val items = "1234567asdfghj"
        val actual = Rucksack.createFrom(items)
        expectThat(actual).isEqualTo(Rucksack("1234567", "asdfghj"))
    }

    @Test
    fun `get misplaced item`() {
        val rucksack = Rucksack("1234567", "asdfg6j")
        val actual = rucksack.getMisplacedItem()
        expectThat(actual).isEqualTo('6')
    }

    @Test
    fun `get Priority of a, z, A and Z`() {
        expectThat(Rucksack.getPriorityOf('a')).isEqualTo(1)
        expectThat(Rucksack.getPriorityOf('z')).isEqualTo(26)
        expectThat(Rucksack.getPriorityOf('A')).isEqualTo(27)
        expectThat(Rucksack.getPriorityOf('Z')).isEqualTo(52)
    }
}