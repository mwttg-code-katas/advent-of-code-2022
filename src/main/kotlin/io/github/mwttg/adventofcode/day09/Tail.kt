package io.github.mwttg.adventofcode.day09

import kotlin.math.sign

data class Tail(
    val position: Position = Position(),
    val visitedPosition: List<Position> = listOf(Position()),
) {

    fun nextStep(headPosition: Position): Tail {
        val shouldMove = mustTailFollow(headPosition)
        if (shouldMove) {
            val newPosition = move(headPosition)
            return Tail(newPosition, visitedPosition + newPosition)
        }

        return Tail(position, visitedPosition)
    }

    private fun move(headPosition: Position): Position {
        val deltaX = headPosition.x - position.x
        val deltaY = headPosition.y - position.y
        return Position(position.x + deltaX.sign, position.y + deltaY.sign)
    }

    private fun mustTailFollow(headPosition: Position): Boolean {
        val neighbours = headPosition.neighbours()
        return setOf(position).intersect(neighbours).isEmpty()
    }
}
