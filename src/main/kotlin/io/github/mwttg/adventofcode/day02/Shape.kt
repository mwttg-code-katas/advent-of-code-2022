package io.github.mwttg.adventofcode.day02

enum class Shape(private val points: Int) {

    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    fun getScore(other: Shape): Int = when (Pair(this, other)) {
        Pair(ROCK, ROCK) -> Result.DRAW.points + ROCK.points
        Pair(ROCK, PAPER) -> Result.LOSE.points + ROCK.points
        Pair(ROCK, SCISSOR) -> Result.WIN.points + ROCK.points
        Pair(PAPER, ROCK) -> Result.WIN.points + PAPER.points
        Pair(PAPER, PAPER) -> Result.DRAW.points + PAPER.points
        Pair(PAPER, SCISSOR) -> Result.LOSE.points + PAPER.points
        Pair(SCISSOR, ROCK) -> Result.LOSE.points + SCISSOR.points
        Pair(SCISSOR, PAPER) -> Result.WIN.points + SCISSOR.points
        Pair(SCISSOR, SCISSOR) -> Result.DRAW.points + SCISSOR.points
        else -> throw Exception("Not Possible")
    }

    companion object {

        fun createFrom(sign: String): Shape = when (sign) {
            "A", "X" -> ROCK
            "B", "Y" -> PAPER
            "C", "Z" -> SCISSOR
            else -> throw Exception("Unknown sign '$sign'")
        }
    }
}