package io.github.mwttg.adventofcode.day09

enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    fun nextPosition(currentPosition: Position): Position =
        when (this) {
            UP -> currentPosition.moveUp()
            DOWN -> currentPosition.moveDown()
            LEFT -> currentPosition.moveLeft()
            RIGHT -> currentPosition.moveRight()
        }
}