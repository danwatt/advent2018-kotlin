package org.danwatt

class Day5 : Day<Int, Int>(5) {
    override fun partOne(): Int = react(loadLines()[0]).length

    override fun partTwo(): Int = findProblematic(loadLines()[0]).second

    fun react(s: String): String {
        var temp = s.substring(0, 1)
        var i = 1
        loop@ while (i < s.length) {
            val next = s[i++]
            if (temp.isEmpty()) {
                temp += next
                continue@loop
            }
            when {
                reacts(next, temp.last()) -> temp = temp.substring(0, temp.length - 1)
                else -> temp += next
            }
        }

        return temp
    }

    private fun reacts(next: Char, here: Char) = next.toLowerCase() == here.toLowerCase() && next != here
    fun findProblematic(s: String): Pair<Char, Int> {
        return ('a'..'z')
            .map { it to react(s.replace(it.toString(), "").replace(it.toString().toUpperCase(), "")).length }
            .minBy { it.second }!!

    }
}

private fun String.last(): Char = this[this.length - 1]
