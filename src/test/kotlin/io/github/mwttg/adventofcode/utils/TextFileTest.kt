package io.github.mwttg.adventofcode.utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import strikt.api.expectThat
import strikt.assertions.containsExactly

internal class TextFileTest {

    @Test
    fun `read a valid text file from resources folder`() {
        expectThat(
            TextFile.readFromResources("text.txt")
        ).containsExactly(
            "1. line",
            "2. line",
            "3. line"
        )
    }

    @Test
    fun `try to read a text file from resources, that don't exists`() {
        assertThrows<NullPointerException> { TextFile.readFromResources("file-that-doesnt-exists.txt") }
    }
}