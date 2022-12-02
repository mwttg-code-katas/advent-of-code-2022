package io.github.mwttg.adventofcode.day02

private const val DRAW_SCORE = 3
private const val WIN_SCORE = 6
private const val LOSE_SCORE = 0
private const val ROCK_SCORE = 1
private const val PAPER_SCORE = 2
private const val SCISSOR_SCORE = 3

enum class Shape {

    ROCK,
    PAPER,
    SCISSOR;

    fun getScore(other: Shape): Int = when (Pair(this, other)) {
        Pair(ROCK, ROCK) -> DRAW_SCORE + ROCK_SCORE
        Pair(ROCK, PAPER) -> LOSE_SCORE + ROCK_SCORE
        Pair(ROCK, SCISSOR) -> WIN_SCORE + ROCK_SCORE
        Pair(PAPER, ROCK) -> WIN_SCORE + PAPER_SCORE
        Pair(PAPER, PAPER) -> DRAW_SCORE + PAPER_SCORE
        Pair(PAPER, SCISSOR) -> LOSE_SCORE + PAPER_SCORE
        Pair(SCISSOR, ROCK) -> LOSE_SCORE + SCISSOR_SCORE
        Pair(SCISSOR, PAPER) -> WIN_SCORE + SCISSOR_SCORE
        Pair(SCISSOR, SCISSOR) -> DRAW_SCORE + SCISSOR_SCORE
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