package io.github.mwttg.adventofcode.day09

private const val SPACE = " "

data class Motion(val direction: Direction, val units: Int) {

    fun createActions(): List<Direction> {
        val actions = mutableListOf<Direction>()
        repeat(units) { actions.add(direction) }
        return actions
    }

    companion object {

        fun create(text: String): Motion {
            val (direction, units) = text.split(SPACE)
            return when (direction) {
                "U" -> Motion(Direction.UP, units.toInt())
                "D" -> Motion(Direction.DOWN, units.toInt())
                "L" -> Motion(Direction.LEFT, units.toInt())
                "R" -> Motion(Direction.RIGHT, units.toInt())
                else -> throw Exception("Not possible")
            }
        }
    }
}
