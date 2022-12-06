package io.github.mwttg.adventofcode.day06

import java.io.File
import kotlin.system.measureTimeMillis

const val PACKET_WINDOW_SIZE = 4
const val MESSAGE_WINDOW_SIZE = 14
private const val FILENAME = "./puzzle-inputs/day06/input.txt"

fun main() {
    val packetMarker: Int
    val time1 = measureTimeMillis { packetMarker = findMarker(readFile(), PACKET_WINDOW_SIZE) }
    println("The first start-of-packet marker was found after '$packetMarker' characters. This took $time1 ms.")

    val messageMarker: Int
    val time2 = measureTimeMillis { messageMarker = findMarker(readFile(), MESSAGE_WINDOW_SIZE) }
    println("The first start-of-message marker was found after '$messageMarker' characters. This took $time2 ms.")
}

fun readFile() = File(FILENAME).readText()

fun findMarker(input: String, windowSize: Int): Int {
    var uniqueIndex = 0
    val window = Window(windowSize = windowSize)
    for ((index, c) in input.withIndex()) {
        window.add(c)
        if (window.isUnique()) {
            uniqueIndex = index
            break
        }
    }
    return uniqueIndex + 1
}