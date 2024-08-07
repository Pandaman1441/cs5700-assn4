import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class EmulatorTest {

    @Test
    fun testEmulatorExecution() {
        val emulator = Emulator

        emulator.start("roms/hello.out")

        assertEquals('H', emulator.screen.grid[0][0])
        assertEquals('E', emulator.screen.grid[0][1])
        assertEquals('L', emulator.screen.grid[0][2])
        assertEquals('L', emulator.screen.grid[0][3])
        assertEquals('O', emulator.screen.grid[0][4])
    }
}