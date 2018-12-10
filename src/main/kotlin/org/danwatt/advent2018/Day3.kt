package org.danwatt.advent2018

class Day3 : Day<Int, Int>(3) {
    private val dimension = 1000

    override fun partOne(): Int = numberOfOverlaps(loadLines())

    override fun partTwo() = findNonOverlapping(loadLines())

    fun numberOfOverlaps(claims: List<String>): Int {
        //Multidimensional arrays in Kotlin are not as easy as in Java, so for this one we are going to use a single array
        val (grid, _) = computeGrids(claims)
        return grid.count { cell -> cell > 1 }
    }

    private fun computeGrids(claims: List<String>): Pair<IntArray, Set<Int>> {
        val p = Regex("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)")


        val grid = IntArray(dimension * dimension) { 0 }
        val gridClaims = IntArray(dimension * dimension) { 0 }
        val nonOverlappingClaims = mutableSetOf<Int>()

        claims.forEach { claim ->
            val (claimNumber, leftOffset, topOffset, width, height) = p.find(claim)!!.groupValues
                .filterIndexed { index, s -> index > 0 }// Discard group 0 (the entire match)
                .map { Integer.parseInt(it) }
            nonOverlappingClaims.add(claimNumber)

            for (j in 0..(height - 1)) {
                (0..(width - 1)).forEach {
                    val cell = dimension * (topOffset + j) + leftOffset + it
                    grid[cell]++
                    when {
                        gridClaims[cell] > 0 -> {
                            nonOverlappingClaims.removeAll(setOf(claimNumber,gridClaims[cell]))
                            gridClaims[cell] = -1
                        }
                        gridClaims[cell] == 0 -> gridClaims[cell] = claimNumber
                    }
                }
            }
        }
        dump(gridClaims)
        return grid to nonOverlappingClaims
    }

    fun findNonOverlapping(claims: List<String>): Int = computeGrids(claims).component2().first()

    private fun dump(gc: IntArray) {
        gc.asList().chunked(dimension).subList(0, 10)
            .forEach { chunk ->
                println(
                    chunk.joinToString("")
                        .replace("-1", "X")
                        .replace("0", ".")
                        .substring(0, 10)
                )
            }
    }
}