package org.danwatt

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TestHelpers {
    companion object {
        fun decode(i: Int): Int {
            return i xor TestHelpers.SCRAMBLE
        }

        val SCRAMBLE = 0x5F3759DF
    }
}