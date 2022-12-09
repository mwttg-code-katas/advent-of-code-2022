package io.github.mwttg.adventofcode.day09

data class Head(private val actions: List<Direction>, val position: Position = Position()) {

    fun nextStep() = Head(
        actions = actions.drop(1),
        position = actions.first().nextPosition(position)
    )

    fun actionsLeft() = actions.size
}