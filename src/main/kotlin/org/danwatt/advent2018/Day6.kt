package org.danwatt.advent2018

import java.util.concurrent.atomic.AtomicInteger

class Day6 : Day<Int, Int>(6) {
    override fun partOne(): Int {
        return computeBestLocation(1000, loadLines())
    }

    override fun partTwo(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun computeBestLocation(gridSize: Int, stringCoords: List<String>): Int {
        val coords = stringCoords.map { it.split(", ") }.map { it[1].toInt() to it[0].toInt() }
        val idsThatAreInfinite = mutableSetOf<Int>()
        val counter = mutableMapOf<Int, AtomicInteger>()

        for (row in 0..(gridSize - 1)) {
            for (column in 0..(gridSize - 1)) {
                val distances = coords
                    .mapIndexed { index, coordinate ->
                        index to manhattanDistance(
                            coordinate,
                            row to column
                        )
                    }
                val closest = distances.minBy { it.second }!!
                val numMatchingClosest = distances.count { it.second == closest.second }
                val closestId = closest.first + 1
                if (numMatchingClosest == 1) {
                    counter.putIfAbsent(closestId, AtomicInteger())
                    counter[closestId]!!.incrementAndGet()
                    if (row == 0 || column == 0 || row == gridSize - 1 || column == gridSize - 1) {
                        idsThatAreInfinite.add(closestId)
                    }
                }
            }
        }

        return counter.filterKeys { !idsThatAreInfinite.contains(it) && it > 0 }.maxBy { it.value.get() }!!.value.get()
    }


    fun manhattanDistance(c1: Pair<Int, Int>, c2: Pair<Int, Int>): Int =
        Math.abs(c2.first - c1.first) + Math.abs(c2.second - c1.second)

}
