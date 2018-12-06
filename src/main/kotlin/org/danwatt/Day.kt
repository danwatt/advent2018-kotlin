package org.danwatt

import java.io.File

abstract class Day(val dayNumber: Int) {
    abstract fun partOne(): Int

    protected fun loadLines() = File(ClassLoader.getSystemResource("day$dayNumber.txt").file)
        .readLines()

    abstract fun partTwo(): Int
}