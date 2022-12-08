package io.github.mwttg.adventofcode.day08

object MarkTrees {

    fun markVisibleTrees(grid: Grid) {
        val horizontalPositions = getHorizontals(grid)
        val verticalPositions = getVerticals(grid)
        val positions = horizontalPositions.union(verticalPositions)
        positions.forEach { grid.markVisible(it.x, it.y) }
    }

    private fun getHorizontals(grid: Grid): MutableSet<Position> {
        val positions = mutableSetOf<Position>()
        for (rowIndex in 1 until grid.getRows() - 1) {
            val row = grid.extractRow(rowIndex)
            val lrPositions = VisibleTrees.getVisiblePositionLR(rowIndex, row)
            val rlPositions = VisibleTrees.getVisiblePositionRL(rowIndex, row)
            positions.addAll(lrPositions)
            positions.addAll(rlPositions)
        }
        return positions
    }

    private fun getVerticals(grid: Grid): MutableSet<Position> {
        val positions = mutableSetOf<Position>()
        for(columnIndex in 1 until grid.getColumns() - 1) {
            val column = grid.extractColumn(columnIndex)
            val tbPosition = VisibleTrees.getVisiblePositionTB(columnIndex, column)
            val btPosition = VisibleTrees.getVisiblePositionBT(columnIndex, column)
            positions.addAll(tbPosition)
            positions.addAll(btPosition)
        }
        return positions
    }
}