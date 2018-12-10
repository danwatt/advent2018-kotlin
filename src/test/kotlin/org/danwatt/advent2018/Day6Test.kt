package org.danwatt.advent2018

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day6Test {
    /*
    --- Day 6: Chronal Coordinates ---
    The device on your wrist beeps several times, and once again you feel like you're falling.

    "Situation critical," the device announces. "Destination indeterminate. Chronal interference detected.
    Please specify new target coordinates."

    The device then produces a list of coordinates (your puzzle input). Are they places it thinks are safe or dangerous?
    It recommends you check manual page 729. The Elves did not give you a manual.

    If they're dangerous, maybe you can minimize the danger by finding the coordinate that gives the largest distance
    from the other points.

    Using only the Manhattan distance, determine the area around each coordinate by counting the number of integer X,Y
    locations that are closest to that coordinate (and aren't tied in distance to any other coordinate).

    Your goal is to find the size of the largest area that isn't infinite. For example, consider the following list of
    coordinates:

    1, 1
    1, 6
    8, 3
    3, 4
    5, 5
    8, 9
    If we name these coordinates A through F, we can draw them on a grid, putting 0,0 at the top left:

    ..........
    .A........
    ..........
    ........C.
    ...D......
    .....E....
    .B........
    ..........
    ..........
    ........F.
    This view is partial - the actual grid extends infinitely in all directions. Using the Manhattan distance, each
    location's closest coordinate can be determined, shown here in lowercase:

    aaaaa.cccc
    aAaaa.cccc
    aaaddecccc
    aadddeccCc
    ..dDdeeccc
    bb.deEeecc
    bBb.eeee..
    bbb.eeefff
    bbb.eeffff
    bbb.ffffFf
    Locations shown as . are equally far from two or more coordinates, and so they don't count as being closest to any.

    In this example, the areas of coordinates A, B, C, and F are infinite - while not shown here, their areas extend
    forever outside the visible grid. However, the areas of coordinates D and E are finite: D is closest to 9 locations,
    and E is closest to 17 (both including the coordinate's location itself). Therefore, in this example, the size of
    the largest area is 17.

    What is the size of the largest area that isn't infinite?
     */
    @Test
    fun example1() {
        val example = listOf("1, 1", "1, 6", "8, 3", "3, 4", "5, 5", "8, 9")
        assertThat(Day6().manhattanDistance(0 to 0, 1 to 1)).isEqualTo(2)
        assertThat(Day6().manhattanDistance(1 to 1, 3 to 4)).isEqualTo(5)
        assertThat(Day6().computeBestLocation(10, example)).isEqualTo(17)
    }

    @Test
    fun partOne() {
        //11672 : Too high
        assertThat(Day6().partOne()).isEqualTo(TestHelpers.decode(0x5f374d31))
    }
}