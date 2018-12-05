package org.danwatt

import java.io.File

class Day1 : Day {
    override fun compute(): Int =
        loadLines().sum()

    private fun loadLines() = File(ClassLoader.getSystemResource("day1.txt").file)
        .readLines().map { Integer.parseInt(it) }

    fun computePartTwo(): Int = firstRepeat(loadLines())

    fun firstRepeat(ints: List<Int>): Int {
        val encountered = mutableSetOf<Int>()
        var workingFrequency = 0;
        while (true) {
            ints.forEach {
                encountered.add(workingFrequency)
                workingFrequency += it
                if (encountered.contains(workingFrequency)) {
                    return workingFrequency
                }
            }
        }
        //Note this is unreachable
    }
}