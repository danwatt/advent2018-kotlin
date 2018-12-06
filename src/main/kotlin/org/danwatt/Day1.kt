package org.danwatt

class Day1 : Day(1) {
    override fun partOne(): Int =
        loadLinesAsIntegers().sum()


    override fun partTwo(): Int = firstRepeat(loadLinesAsIntegers())

    private fun loadLinesAsIntegers() = loadLines().map { Integer.parseInt(it) }

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