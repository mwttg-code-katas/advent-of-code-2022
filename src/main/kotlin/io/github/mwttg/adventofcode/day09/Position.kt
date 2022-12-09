package io.github.mwttg.adventofcode.day09

data class Position(val x: Int = 0, val y: Int = 0) {

    fun moveUp() = Position(x, y + 1)

    fun moveDown() = Position(x, y - 1)

    fun moveLeft() = Position(x - 1, y)

    fun moveRight() = Position(x + 1, y)

    fun neighbours(): Set<Position> {
        val neighbours = mutableSetOf<Position>()
        for (t in -1 ..1) {
            for (s in -1 .. 1) {
                neighbours.add(Position(x + s, y + t))
            }
        }
        return neighbours
    }
}
