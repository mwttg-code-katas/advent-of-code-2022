package io.github.mwttg.adventofcode.day08

object CountTrees {

    fun countVisibleTrees(grid: Grid): Int {
        val horizontalPositions = getHorizontalVisibleTrees(grid)
        val verticalPositions = getVerticalVisibleTrees(grid)
        val positions = horizontalPositions.union(verticalPositions)
        return positions.size + (2 * grid.getRows()) + (2 * grid.getColumns()) - 4
    }

    private fun getHorizontalVisibleTrees(grid: Grid): MutableSet<Position> {
        val positions = mutableSetOf<Position>()
        for (rowIndex in 1 until grid.getRows() - 1) {
            val row = grid.extractRow(rowIndex)
            val lrPositions = VisibleTrees.fromLeftToRight(rowIndex, row)
            val rlPositions = VisibleTrees.fromRightToLeft(rowIndex, row)
            positions.addAll(lrPositions)
            positions.addAll(rlPositions)
        }
        return positions
    }

    private fun getVerticalVisibleTrees(grid: Grid): MutableSet<Position> {
        val positions = mutableSetOf<Position>()
        for(columnIndex in 1 until grid.getColumns() - 1) {
            val column = grid.extractColumn(columnIndex)
            val tbPosition = VisibleTrees.fromTopToBottom(columnIndex, column)
            val btPosition = VisibleTrees.fromBottomToTop(columnIndex, column)
            positions.addAll(tbPosition)
            positions.addAll(btPosition)
        }
        return positions
    }
}