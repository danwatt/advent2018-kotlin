package org.danwatt

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AllDaysTest {
    @Test
    fun day1() {
        assertThat(Day1().compute()).isEqualTo(569);
    }
}