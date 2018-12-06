package org.danwatt

import java.io.File

abstract class  Day<T1,T2>(val dayNumber: Int) {
    abstract fun partOne(): T1

    protected fun loadLines() = File(ClassLoader.getSystemResource("day$dayNumber.txt").file)
        .readLines()

    abstract fun partTwo(): T2
}