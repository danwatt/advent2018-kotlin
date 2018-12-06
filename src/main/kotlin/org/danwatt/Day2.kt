package org.danwatt

class Day2 : Day(2) {
    override fun partOne(): Int = checksum(this.loadLines())

    fun checksum(boxIds: List<String>): Int {
        val part1 = boxIds.count { boxId -> boxId.toCharArray().any { it -> boxId.count { chr -> chr == it } == 2 } }
        val part2 = boxIds.count { boxId -> boxId.toCharArray().any { it -> boxId.count { chr -> chr == it } == 3 } }

        return part1 * part2;
    }

    override fun partTwo(): Int = 0
}