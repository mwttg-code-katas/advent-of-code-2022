package io.github.mwttg.adventofcode.day02

enum class Shape(private val points: Int, private val symbol: String) {

    ROCK(1, "A"),
    PAPER(2, "B"),
    SCISSOR(3, "C");

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

    fun getHand(result: Result) = when (Pair(this, result)) {
        Pair(ROCK, Result.WIN) -> PAPER
        Pair(ROCK, Result.DRAW) -> ROCK
        Pair(ROCK, Result.LOSE) -> SCISSOR
        Pair(PAPER, Result.WIN) -> SCISSOR
        Pair(PAPER, Result.DRAW) -> PAPER
        Pair(PAPER, Result.LOSE) -> ROCK
        Pair(SCISSOR, Result.WIN) -> ROCK
        Pair(SCISSOR, Result.DRAW) -> SCISSOR
        Pair(SCISSOR, Result.LOSE) -> PAPER
        else -> throw Exception("Not Possible")
    }

    companion object {

        fun createFromSymbol(symbol: String) = when (symbol) {
            ROCK.symbol -> ROCK
            PAPER.symbol -> PAPER
            SCISSOR.symbol -> SCISSOR
            else -> throw Exception("Unknown symbol '$symbol'")
        }

        fun createFrom(sign: String): Shape = when (sign) {
            "X" -> ROCK
            "Y" -> PAPER
            "Z" -> SCISSOR
            else -> throw Exception("Unknown sign '$sign'")
        }
    }
}