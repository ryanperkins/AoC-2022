fun main() {
    println("Part 1: " + Day6.part1())
    println("Part 2: " + Day6.part2())
}

object Day6 {
    val input = getInputStrings("day6").first()

    fun part1():Int {
        input.windowed(4, 1).forEachIndexed { index, set ->
            if (set.toCharArray().distinct().size == 4) return index+4
        }
        return 0
    }

    fun part2():Int {
        input.windowed(14, 1).forEachIndexed { index, set ->
            if (set.toCharArray().distinct().size == 14) return index+14
        }
        return 0
    }
}