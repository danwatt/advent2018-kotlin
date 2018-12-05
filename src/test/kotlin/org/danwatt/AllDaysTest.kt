package org.danwatt

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AllDaysTest {
    @Test
    fun day1() {
        assertThat(Day1().compute()).isEqualTo(569);
        assertThat(Day1().firstRepeat(listOf(1, -1))).isEqualTo(0)
        assertThat(Day1().firstRepeat(listOf(3, 3, 4, -2, -4))).isEqualTo(10)
        assertThat(Day1().firstRepeat(listOf(-6, 3, 8, 5, -6))).isEqualTo(5)
        assertThat(Day1().firstRepeat(listOf(7, 7, -2, -7, -4))).isEqualTo(14)
        assertThat(Day1().computePartTwo()).isEqualTo(0)
    }
}