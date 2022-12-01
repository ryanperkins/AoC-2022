fun main() {
    println("Part 1: " + Day1.part1())
    println("Part 2: " + Day1.part2())
}

object Day1 {
    val input = getInputInts("day1")
    var elves: MutableList<MutableList<Int>> = (mutableListOf<MutableList<Int>>(mutableListOf())).apply {
        input.forEach {
            if (it == null) {
                this.add(mutableListOf<Int>())
            } else {
                this.last().add(it)
            }
        }
    }

    fun part1():Int = elves.maxOf { it.sum() }

    fun part2():Int {
        elves.sortByDescending { it.sum() }
        return elves.subList(0,3).map { it.sum() }.sum()
    }
}

