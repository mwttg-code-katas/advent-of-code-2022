package io.github.mwttg.adventofcode.day09

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day09/input.txt"

fun main() {
    val visited: Int
    val time1 = measureTimeMillis { visited = tailVisitedOnce() }
    println("The Tail knot visited '$visited' positions at least once. This took $time1 ms.")
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

fun createActions() = File(FILENAME)
        .readLines()
        .flatMap { Motion.create(it).createActions() }
