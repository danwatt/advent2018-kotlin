package org.danwatt

import java.io.File

class Day1 : Day {
    override fun compute(): Int =
        File(ClassLoader.getSystemResource("day1.txt").file)
            .readLines()
            .map { Integer.parseInt(it) }
            .sum()
}