import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test: BaseTest() {
    object Expect {
        val part1 = 0
        val part2 = 0
    }

    @Test
    internal fun testPart1() {
        assertEquals(Expect.part1, Day2.part1())
    }

    @Test
    internal fun testPart2() {
        assertEquals(Expect.part2, Day2.part2())
    }
}