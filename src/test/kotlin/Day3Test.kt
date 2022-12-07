import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test: BaseTest() {
    object Expect {
        val part1 = 157
        val part2 = 70
    }

    @Test
    internal fun testPart1() {
        assertEquals(Expect.part1, Day3.part1())
    }

    @Test
    internal fun testPart2() {
        assertEquals(Expect.part2, Day3.part2())
    }
}