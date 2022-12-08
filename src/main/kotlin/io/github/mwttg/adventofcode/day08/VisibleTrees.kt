package io.github.mwttg.adventofcode.day08

object VisibleTrees {

    fun fromLeftToRight(index: Int, row: List<Int>): Set<Position> =
        getPositions(index, row, row.first(), row.indices, this::vPosition)

    fun fromRightToLeft(index: Int, row: List<Int>): Set<Position> =
        getPositions(index, row, row.last(), row.indices.reversed(), this::vPosition)

    fun fromTopToBottom(index: Int, column: List<Int>): Set<Position> =
        getPositions(index, column, column.first(), column.indices, this::hPosition)

    fun fromBottomToTop(index: Int, column: List<Int>): Set<Position> =
        getPositions(index, column, column.last(), column.indices.reversed(), this::hPosition)

    private fun getPositions(
        index: Int,
        items: List<Int>,
        initialHeight: Int,
        range: IntProgression,
        positionFunc: (index: Int, coordinate: Int) -> Position,
    ): Set<Position> {
        val positions = mutableSetOf<Position>()
        var currentHeight = initialHeight
        for (itemIndex in range) {
            if (items[itemIndex] <= currentHeight) {
                continue
            } else {
                currentHeight = items[itemIndex]
                positions.add(positionFunc(index, itemIndex))
            }
        }
        return positions
    }

    private fun hPosition(index: Int, y: Int) = Position(index, y)

    private fun vPosition(index: Int, x: Int) = Position(x, index)
}