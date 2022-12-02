package io.github.mwttg.adventofcode.day02

enum class Result(val points: Int, val symbol: String) {

    WIN(6, "Z"),
    DRAW(3, "Y"),
    LOSE(0, "X");

    companion object {

        fun createFromSymbol(symbol: String) = when (symbol) {
            WIN.symbol -> WIN
            DRAW.symbol -> DRAW
            LOSE.symbol -> LOSE
            else -> throw Exception("Unknown symbol '$symbol'")
        }
    }
}