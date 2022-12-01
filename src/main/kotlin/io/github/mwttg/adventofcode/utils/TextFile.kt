package io.github.mwttg.adventofcode.utils

import java.io.File

object TextFile {

    fun readFromResources(filename: String): List<String> {
        val resource = this.javaClass.classLoader.getResource(filename)!!.path
        return File(resource).readLines()
    }
}