package io.github.mwttg.adventofcode.day06

class Window(
    private val windowSize: Int = 4,
    private val content: MutableList<Char> = mutableListOf(),
) {

    fun add(char: Char) {
        content.add(char)
        if (content.size > windowSize) content.removeAt(0)
    }

    fun isUnique() = content.size == windowSize && content.toSet().size == windowSize
}