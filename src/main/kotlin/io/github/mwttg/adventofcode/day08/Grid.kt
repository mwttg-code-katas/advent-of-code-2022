package io.github.mwttg.adventofcode.day08

class Grid(private val grid: List<List<Int>>) {

    private val markerGrid = createVisibleTreesGrid(grid)

    private fun createVisibleTreesGrid(grid: List<List<Int>>): Array<IntArray> {
        val maxColumn = grid[0].size
        val maxRow = grid.size
        val result = Array(maxRow) { IntArray(maxColumn) }

        for (y in 0 until maxRow) {
            result[y][0] = 1
            result[y][maxColumn - 1] = 1
        }
        for (x in 1 until maxColumn - 1) {
            result[0][x] = 1
            result[maxRow - 1][x] = 1
        }

        return result
    }

    fun getRows() = grid.size

    fun getColumns() = grid[0].size

    fun extractRow(rowIndex: Int) = grid[rowIndex]

    fun extractColumn(columnIndex: Int) = grid.map { it[columnIndex] }

    fun markVisible(x: Int, y: Int) {
        markerGrid[y][x] = 1
    }

    fun getSumOfVisibleTrees() = markerGrid.sumOf { row -> row.sum() }
}