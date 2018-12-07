package org.danwatt

class Day4 : Day<Int, Int>(4) {
    override fun partOne(): Int {
        val (id, minute) = strategy1(loadLines())
        return id * minute
    }

    override fun partTwo(): Int {
        val (id, minute) = strategy2(loadLines())
        return id * minute
    }

    fun strategy1(lines: List<String>): Pair<Int, Int> {
        val guardSleepCounter = computeGuardSleepCounter(lines)

        //dump(guardSleepCounter)

        val candidate = guardSleepCounter.maxBy { it.value.sum() }
        return candidate!!.key to candidate.value.maxWithIndex()!!.second
    }

    private fun computeGuardSleepCounter(lines: List<String>): MutableMap<Int, IntArray> {
        val sorted = lines.sorted();
        val guardSleepCounter = mutableMapOf<Int, IntArray>()

        val guardRegex = Regex("#(\\d+)")
        val minuteRegex = Regex("(\\d\\d)]")
        var currentGuard = 0;
        var sleeping = -1;
        sorted.forEach { line ->
            val minute = minuteRegex.find(line)!!.groupValues[1].toInt()
            val guardChange = guardRegex.find(line)
            when {
                guardChange != null -> {
                    currentGuard = guardChange.groupValues[1].toInt()
                    guardSleepCounter.computeIfAbsent(currentGuard) { IntArray(60) }
                    sleeping = -1
                }
                line.contains("falls") -> sleeping = minute
                line.contains("wakes") -> for (i in sleeping..minute) {
                    guardSleepCounter[currentGuard]!![i]++
                }
            }
        }
        return guardSleepCounter
    }

    private fun dump(guardSleepCounter: MutableMap<Int, IntArray>) {
        guardSleepCounter.forEach { id, ar ->
            val (max, idx) = ar.maxWithIndex()!!
            println("$id : ${ar.joinToString("")}. $max, $idx, ${ar.sum()}")
        }
    }

    fun strategy2(lines: List<String>): Pair<Int, Int> {
        val guardSleepCounter = computeGuardSleepCounter(lines)
        val candidate = guardSleepCounter.maxBy { gsc-> gsc.value.max()!! }
        return candidate!!.key to candidate.value.maxWithIndex()!!.second
    }
}

private fun IntArray.maxWithIndex(): Pair<Int, Int>? {
    var candidate: Pair<Int, Int>? = null
    this.forEachIndexed { index, value ->
        if (null == candidate || value > candidate!!.first) {
            candidate = value to index
        }
    }
    return candidate
}
