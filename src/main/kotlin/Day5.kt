fun main() {
    println("Part 1: " + Day5.part1())
    println("Part 2: " + Day5.part2())
}

object Day5 {
    val input = getInputStrings("day5")
    val stacks = mutableListOf<MutableList<Char>>()
    val instructs = mutableListOf<Instruct>()

    init {
        val blankLine = input.indexOf("")
        val stackLists = input.subList(0, blankLine-1)
        val rawInstuct = input.subList(blankLine+1, input.count())

        stackLists.reversed().forEach {
            it.forEachIndexed { index, char ->
                if (char != ' ' && char != '[' && char != ']') {
                    val col = Math.abs((index)/4)
                    stacks.getOrElse(col) { stacks.add(mutableListOf()) }
                    stacks.get(col).add(char)
                }
            }
        }

        rawInstuct.forEach {
            val breakdown = it.split(" ")
            instructs.add(Instruct(breakdown.get(1).toInt(), breakdown.get(3).toInt()-1, breakdown.get(5).toInt()-1))
        }
    }

    fun part1():String {
//        instructs.forEach { instruct ->
//            (1..instruct.count).forEach {
//                stacks.get(instruct.endCol).add(stacks.get(instruct.startCol).removeLast())
//
//            }
//        }
        return stacks.map { it.last() }.joinToString("")
    }

    fun part2():String {
        stacks.forEach {
            println(it)
        }
        instructs.forEach { instruct ->
            val startStack = stacks.get(instruct.startCol)
            println(instruct)
            println(startStack.size)
            val moved = startStack.subList(startStack.size-instruct.count, startStack.size)
            stacks.get(instruct.endCol).addAll(moved)
            (1..instruct.count).forEach { startStack.removeLast() }
        }
        return stacks.map { it.last() }.joinToString("")
    }
}

data class Instruct(val count: Int, val startCol: Int, val endCol: Int)