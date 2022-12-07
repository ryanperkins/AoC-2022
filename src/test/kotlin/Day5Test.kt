import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5Test: BaseTest() {
    object Expect {
        val part1 = "CMZ"
        val part2 = "MCD"
    }

//    @Test
//    internal fun testPart1() {
//        assertEquals(Expect.part1, Day5.part1())
//    }

    @Test
    internal fun testPart2() {
        assertEquals(Expect.part2, Day5.part2())
    }
}