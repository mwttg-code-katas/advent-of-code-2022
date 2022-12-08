package io.github.mwttg.adventofcode.day08

object VisibleTrees {

    fun getVisiblePositionLR(index: Int, row: List<Int>): Set<Position> =
        getVisiblePositions(
            index,
            row,
            this::horizontalPosition
        )

    fun getVisiblePositionRL(index: Int, row: List<Int>): Set<Position> =
        getVisiblePositionsReverse(
            index,
            row,
            this::horizontalPosition
        )

    fun getVisiblePositionTB(index: Int, column: List<Int>): Set<Position> =
        getVisiblePositions(
            index,
            column,
            this::verticalPosition
        )

    fun getVisiblePositionBT(index: Int, column: List<Int>): Set<Position> =
        getVisiblePositionsReverse(
            index,
            column,
            this::verticalPosition
        )

    private fun getVisiblePositions(
        index: Int,
        items: List<Int>,
        positionFunc: (index: Int, coordinate: Int) -> Position,
    ): Set<Position> {
        val positions = mutableSetOf<Position>()
        var currentHeight = items.first()
        val withCutEdges = items.drop(1).dropLast(1)
        for (itemIndex in withCutEdges.indices) {
            if (withCutEdges[itemIndex] <= currentHeight) {
                continue
            } else {
                currentHeight = withCutEdges[itemIndex]
                positions.add(positionFunc(index, itemIndex + 1))
            }
        }
        return positions
    }

    private fun getVisiblePositionsReverse(
        index: Int,
        items: List<Int>,
        positionFunc: (index: Int, coordinate: Int) -> Position,
    ): Set<Position> {
        val positions = mutableSetOf<Position>()
        var currentHeight = items.last()
        val withCutEdges = items.drop(1).dropLast(1)
        for (itemIndex in withCutEdges.size - 1 downTo 0) {
            if (withCutEdges[itemIndex] <= currentHeight) {
                continue
            } else {
                currentHeight = withCutEdges[itemIndex]
                positions.add(positionFunc(index, itemIndex + 1))
            }
        }
        return positions
    }

    private fun verticalPosition(index: Int, y: Int) = Position(index, y)

    private fun horizontalPosition(index: Int, x: Int) = Position(x, index)
}