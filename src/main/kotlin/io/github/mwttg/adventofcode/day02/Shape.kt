package io.github.mwttg.adventofcode.day02

private const val ROCK_SCORE = 1
private const val PAPER_SCORE = 2
private const val SCISSOR_SCORE = 3

enum class Shape {

    ROCK,
    PAPER,
    SCISSOR;

    fun getScore(other: Shape): Int = when (Pair(this, other)) {
        Pair(ROCK, ROCK) -> Result.DRAW.points + ROCK_SCORE
        Pair(ROCK, PAPER) -> Result.LOSE.points + ROCK_SCORE
        Pair(ROCK, SCISSOR) -> Result.WIN.points + ROCK_SCORE
        Pair(PAPER, ROCK) -> Result.WIN.points + PAPER_SCORE
        Pair(PAPER, PAPER) -> Result.DRAW.points + PAPER_SCORE
        Pair(PAPER, SCISSOR) -> Result.LOSE.points + PAPER_SCORE
        Pair(SCISSOR, ROCK) -> Result.LOSE.points + SCISSOR_SCORE
        Pair(SCISSOR, PAPER) -> Result.WIN.points + SCISSOR_SCORE
        Pair(SCISSOR, SCISSOR) -> Result.DRAW.points + SCISSOR_SCORE
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