fun main() {
    println("Part 1: " + Day4.part1())
    println("Part 2: " + Day4.part2())
}

object Day4 {
    val input = getInputStrings("day4").map { it.split(",").map { it.split("-").map { it.toInt() } } }
        .map { ElfSet(Area(it.first().first(), it.first().last()), Area(it.last().first(), it.last().last())) }

    fun part1():Int {
        return input.count { it.hasTotalOverlap() }
    }

    fun part2():Int {
        return input.count { it.hasAnyOverlap() }
    }
}

data class Area(val low:Int, val high:Int)

data class ElfSet(val area1:Area, val area2:Area) {
    fun hasTotalOverlap(): Boolean {
        if (area1.low >= area2.low && area1.high <= area2.high) return true
        if (area2.low >= area1.low && area2.high <= area1.high) return true
        return false
    }

    fun hasAnyOverlap(): Boolean {
        if (area1.low >= area2.low && area1.low <= area2.high) return true
        if (area1.high >= area2.low && area1.high <= area2.high) return true
        if (area2.low >= area1.low && area2.low <= area1.high) return true
        if (area2.high >= area1.low && area2.high <= area1.high) return true
        return false
    }
}


