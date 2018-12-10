package org.danwatt.advent2018

class TestHelpers {
    companion object {
        fun decode(i: Int): Int {
            return i xor SCRAMBLE
        }

        val SCRAMBLE = 0x5F3759DF
    }
}