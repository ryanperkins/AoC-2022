import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test: BaseTest() {
    object Expect {
        val part1 = 2
        val part2 = 4
    }

    @Test
    internal fun testPart1() {
        assertEquals(Expect.part1, Day4.part1())
    }

    @Test
    internal fun testPart2() {
        assertEquals(Expect.part2, Day4.part2())
    }
}