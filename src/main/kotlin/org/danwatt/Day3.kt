package org.danwatt

class Day3 : Day<Int, Int>(3) {
    override fun partOne(): Int = numberOfOverlaps(loadLines())

    override fun partTwo() = findNonOverlapping(loadLines())

    fun numberOfOverlaps(claims: List<String>): Int {
        //Multidimensional arrays in Kotlin are not as easy as in Java, so for this one we are going to use a single array
        val (grid, _) = computeGrids(claims)
        return grid.count { cell -> cell > 1 }
    }

    private fun computeGrids(claims: List<String>): Pair<IntArray, IntArray> {
        val p = Regex("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)")
        val dimension = 10

        val grid = IntArray(dimension * dimension) { 0 }
        val gridClaims = IntArray(dimension * dimension) { 0 }

        claims.forEach { claim ->
            val (claimNumber, leftOffset, topOffset, width, height) = p.find(claim)!!.groupValues
                .filterIndexed { index, s -> index > 0 }// Discard group 0 (the entire match)
                .map { Integer.parseInt(it) }

            for (j in 0..(height - 1)) {
                (0..(width - 1)).forEach {
                    val cell = dimension * (topOffset + j) + leftOffset + it
                    grid[cell]++
                    when {
                        gridClaims[cell] == 0 -> gridClaims[cell] = claimNumber
                        gridClaims[cell] > 0 -> gridClaims[cell] = -1
                    }
                }
            }
        }
        return grid to gridClaims
    }

    fun findNonOverlapping(claims: List<String>): Int {
        val (_, gc) = computeGrids(claims)
        println(gc.joinToString(" "))
        return gc.find { it > 0 } ?: 0
    }
}