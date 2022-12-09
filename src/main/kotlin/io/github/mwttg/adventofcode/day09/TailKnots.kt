package io.github.mwttg.adventofcode.day09

data class TailKnots(val knots: List<Tail>) {

    fun nextStep(headPosition: Position): TailKnots {
        val result = mutableListOf<Tail>()
        var predecessorPosition = headPosition
        for (knot in knots) {
            val newKnot = knot.nextStep(predecessorPosition)
            predecessorPosition = newKnot.position
            result.add(newKnot)
        }
        return TailKnots(result)
    }
}