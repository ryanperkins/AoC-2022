import java.io.File

object Helpers {
    var path = "src/main/resources/"
}

fun getInputStrings(name: String): List<String> = File("${Helpers.path}$name.txt").readLines().removeTrailingLine()

fun getInputInts(name: String): List<Int?> = getInputStrings(name).map { it.toIntOrNull() }

fun List<String>.removeTrailingLine():List<String> {
    if (this.last().isEmpty()) return this.subList(0, size-1)
    return this
}
