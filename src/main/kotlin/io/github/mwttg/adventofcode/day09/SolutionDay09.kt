package io.github.mwttg.adventofcode.day09

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day09/input.txt"

fun main() {
    val visited: Int
    val time1 = measureTimeMillis { visited = tailVisitedOnce() }
    println("The Tail knot visited '$visited' positions at least once. This took $time1 ms.")

    val visited9: Int
    val time2 = measureTimeMillis { visited9 = tail9VisitedOnce() }
    println("The Tail knot number 9 visited '$visited9' positions at least once. This took $time2 ms.")
}

fun tailVisitedOnce(): Int {
    val actions = createActions()
    var head = Head(actions)
    var tail = Tail()

    while (head.actionsLeft() > 0) {
        head = head.nextStep()
        tail = tail.nextStep(head.position)
    }

    return tail.visitedPosition.toSet().size
}

fun tail9VisitedOnce(): Int {
    val actions = createActions()
    var head = Head(actions)
    var tails = TailKnots(
        listOf(
            Tail(),
            Tail(),
            Tail(),
            Tail(),
            Tail(),
            Tail(),
            Tail(),
            Tail(),
            Tail(),
        )
    )

    while (head.actionsLeft() > 0) {
        head = head.nextStep()
        tails = tails.nextStep(head.position)
    }

    return tails.knots[8].visitedPosition.toSet().size
}

fun createActions() = File(FILENAME)
    .readLines()
    .flatMap { Motion.create(it).createActions() }
