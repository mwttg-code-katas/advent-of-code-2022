package io.github.mwttg.adventofcode.day08

class Grid(private val grid: List<List<Int>>) {

    fun getRows() = grid.size

    fun getColumns() = grid[0].size

    fun extractRow(rowIndex: Int) = grid[rowIndex]

    fun extractColumn(columnIndex: Int) = grid.map { it[columnIndex] }

    fun getMaxScenicScore(): Int {
        var maxScore = 0
        for (y in grid.indices) {
            for (x in 0 until grid[0].size) {
                val score = getScenicScoreFor(x, y)
                if (score > maxScore) maxScore = score
            }
        }
        return maxScore
    }

    private fun getScenicScoreFor(x: Int, y: Int): Int {
        val row = extractRow(y)
        val leftScore = getScoreReverse(x, row)
        val rightScore = getScore(x, row)

        val column = extractColumn(x)
        val topScore = getScoreReverse(y, column)
        val downScore = getScore(y, column)

        return leftScore * rightScore * topScore * downScore
    }

    private fun getScoreReverse(coordinate: Int, items: List<Int>): Int {
        val height = items[coordinate]
        var score = 0
        for (index in coordinate - 1 downTo 0) {
            score++
            if (items[index] >= height) break
        }
        return score
    }

    private fun getScore(coordinate: Int, items: List<Int>): Int {
        val height = items[coordinate]
        var score = 0
        for (index in coordinate + 1 until items.size) {
            score++
            if (items[index] >= height) break
        }
        return score
    }
}