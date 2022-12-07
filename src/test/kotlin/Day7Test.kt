import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day7Test: BaseTest() {
    object Expect {
        val part1 = 95437L
        val part2 = 24933642
    }

    @Test
    internal fun testPart1() {
        assertEquals(Expect.part1, Day7.part1())
    }

    @Test
    internal fun testPart2() {
        assertEquals(Expect.part2, Day7.part2())
    }
}