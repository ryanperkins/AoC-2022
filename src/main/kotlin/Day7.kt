fun main() {
    println("Part 1: " + Day7.part1())
    println("Part 2: " + Day7.part2())
}

object Day7 {
    val input = getInputStrings("day7")
    val rootDir = Dir("/", null)

    init {
        var curDir = rootDir
        input.forEach {
            val breakdown = it.split(" ")
            if (breakdown[0] == "$") {
                if (breakdown[1] == "cd") {
                    if (breakdown[2] == "..") {
                        curDir.parent?.let { curDir = curDir.parent!! }
                    } else {
                        val dir = curDir.children.firstOrNull { it.name == breakdown[2] }
                        if (dir != null) curDir = dir as Dir
                    }
                }
            } else if (breakdown[0] == "dir") {
                curDir.children.add(Dir(breakdown[1], curDir))
            } else {
                curDir.children.add(File(breakdown[1], breakdown[0].toInt(), curDir))
            }
        }
    }

    fun part1():Long {
        return getSmallDirSum(rootDir)
    }

    fun part2():Int {
        val maxSpace = 40000000
        val excess = rootDir.size() - maxSpace
        return getDirList(rootDir).filter { it.size() > excess }.sortedBy { it.size() }.first().size()
    }

    fun getDirList(dir: Dir): MutableList<Dir> {
        val list = mutableListOf<Dir>()
        dir.children.forEach {
            if (it is Dir) {
                list.add(it)
                list.addAll(getDirList(it))
            }
        }
        return list
    }

    fun getSmallDirSum(dir: Dir):Long = dir.children.sumOf {
            if (it is Dir) {
                if (it.size() <= 100000) {
                    return@sumOf it.size() + getSmallDirSum(it)
                } else {
                    return@sumOf getSmallDirSum(it)
                }
            }
            0
        }
}

open class FSElement(val name: String, val parent: Dir?) {
    open fun size():Int = 0
}

class File(name:String, private val fileSize:Int, parent: Dir):FSElement(name, parent) {
    override fun size() = fileSize
}

class Dir(name:String, parent: Dir?):FSElement(name, parent) {
    val children = mutableListOf<FSElement>()
    override fun size() = children.sumOf { it.size() }
}