package org.danwatt

import java.io.File

abstract class Day(val dayNumber: Int) {
    abstract fun compute(): Int

    protected fun loadLines() = File(ClassLoader.getSystemResource("day$dayNumber.txt").file)
        .readLines()
}