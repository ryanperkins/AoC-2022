fun main() {
    println("Part 1: " + Day2.part1())
    println("Part 2: " + Day2.part2())
}

object Day2 {
    val input = getInputStrings("day3")

    fun part1():Int {
        return input.map { Pair(Throw.getThrow(it[0].toString()), Throw.getThrow(it[2].toString())) }.sumOf { Throw.getScore(it) }
    }

    fun part2():Int {
        return input.map { Pair(Throw.getThrow(it[0].toString()), Play.getPlay(it[2].toString())) }
            .map { Pair(it.first, Play.getThrow(it.first, it.second)) }
            .sumOf { Throw.getScore(it) }
    }
}

enum class Play {
    LOSE,
    DRAW,
    WIN;

    companion object {
        fun getPlay(input:String) = when(input) {
            "X" -> LOSE
            "Y" -> DRAW
            else -> WIN
        }

        fun getThrow(oppThrow: Throw, play: Play):Throw {
            if (play == LOSE) {
                return when (oppThrow) {
                    Throw.ROCK -> Throw.SCISSORS
                    Throw.PAPER -> Throw.ROCK
                    else -> Throw.PAPER
                }
            } else if (play == WIN) {
                return when (oppThrow) {
                    Throw.ROCK -> Throw.PAPER
                    Throw.PAPER -> Throw.SCISSORS
                    else -> Throw.ROCK
                }
            }
            return oppThrow
        }
    }
}

enum class Throw(val pts:Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    companion object {
        fun getThrow(input: String) = when(input) {
            "A","X" -> Throw.ROCK
            "B","Y" -> Throw.PAPER
            "C","Z" -> Throw.SCISSORS
            else -> Throw.ROCK
        }

        fun getScore(game: Pair<Throw, Throw>): Int {
            val score:Int = when(game) {
                Pair(ROCK, SCISSORS), Pair(PAPER, ROCK), Pair(SCISSORS, PAPER), -> 0
                Pair(SCISSORS, ROCK), Pair(ROCK, PAPER), Pair(PAPER, SCISSORS), -> 6
                else -> 3
            }
            return score + game.second.pts
        }
    }
}


