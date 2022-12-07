import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day6Test: BaseTest() {
    object Expect {
        val part1 = 7
        val part2 = 19
    }

    @Test
    internal fun testPart1() {
        assertEquals(Expect.part1, Day6.part1())
    }

    @Test
    internal fun testPart2() {
        assertEquals(Expect.part2, Day6.part2())
    }
}