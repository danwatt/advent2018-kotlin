package org.danwatt

class Day2 : Day<Int, String>(2) {
    override fun partOne(): Int = checksum(this.loadLines())

    fun checksum(boxIds: List<String>): Int {
        val part1 = boxIds.count { boxId -> boxId.toCharArray().any { it -> boxId.count { chr -> chr == it } == 2 } }
        val part2 = boxIds.count { boxId -> boxId.toCharArray().any { it -> boxId.count { chr -> chr == it } == 3 } }

        return part1 * part2;
    }

    override fun partTwo(): String = commonCorrectBoxCharacters(loadLines())

    fun commonCorrectBoxCharacters(boxIds: List<String>): String {
        for (i in 0..(boxIds.size - 1)) {
            for (j in i..(boxIds.size - 1)) {
                if (editDistanceIsOne(boxIds[i], boxIds[j])) {
                    return boxIds[i].toCharArray().filterIndexed { idx, c -> boxIds[j][idx] == c }.joinToString("")
                }
            }
        }
        return ""
    }

    fun editDistanceIsOne(s1: String, s2: String): Boolean {
        var edits = 0;
        for (i in 0..(s1.length - 1)) {
            if (s1[i] != s2[i]) {
                edits++;
            }
            if (edits > 1) {
                return false;
            }
        }
        return edits == 1;
    }
}