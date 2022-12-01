import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test: BaseTest() {
    object Expect {
        val part1 = 24000
        val part2 = 45000
    }

    @Test
    internal fun testPart1() {
        assertEquals(Expect.part1, Day1.part1())
    }

    @Test
    internal fun testPart2() {
        assertEquals(Expect.part2, Day1.part2())
    }
}