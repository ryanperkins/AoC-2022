fun main() {
    println("Part 1: " + Day3.part1())
    println("Part 2: " + Day3.part2())
}

object Day3 {
    val input = getInputStrings("day3")

    fun part1():Int {
        return input.map {
            val len = it.length
            Pair(it.substring(0, len/2).toCharArray().toList(), it.substring(len/2).toCharArray().toList())
        }.map { it.first.same(it.second).first() }.map { it.getValue() }.sum()
    }

    fun part2():Int {
        return input.map { it.toCharArray().toList() }.windowed(3, 3, false).map {
            it[0].same(it[1].same(it[2])).first()
        }.sumOf { it.getValue() }
    }
}

fun List<Char>.same(compare:List<Char>): List<Char> = this.filter { compare.contains(it) }

fun Char.getValue():Int {
    if (this.code > 96) return this.code-96
    return this.code - 38
}


