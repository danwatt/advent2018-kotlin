package org.danwatt.advent2018

fun IntArray.maxWithIndex(): Pair<Int, Int>? {
    var candidate: Pair<Int, Int>? = null
    this.forEachIndexed { index, value ->
        if (null == candidate || value > candidate!!.first) {
            candidate = value to index
        }
    }
    return candidate
}

fun String.last(): Char = this[this.length - 1]