import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@OptIn(ExperimentalUnsignedTypes::class)
class InstructionsTest {
    val emulator = Emulator

    @Test
    fun testAddition() {
        emulator.cpu.registers[0] = 0
        emulator.cpu.registers[1] = 3
        emulator.cpu.registers[2] = 5

        val program = ubyteArrayOf(
            0x11.toUByte(), 0x20.toUByte(),
            0x00.toUByte(), 0x00.toUByte()
        )
        for (i in program.indices){
            emulator.rom.memory[i] = program[i]
        }
        emulator.executeCycle()

        assertEquals(8,emulator.cpu.registers[0])
    }

    @Test
    fun testSubtraction() {
        emulator.cpu.registers[0] = 0
        emulator.cpu.registers[1] = 5
        emulator.cpu.registers[2] = 2

        val program = ubyteArrayOf(
            0x21.toUByte(), 0x20.toUByte(),
            0x00.toUByte(), 0x00.toUByte()
        )
        for (i in program.indices){
            emulator.rom.memory[i] = program[i]
        }
        emulator.executeCycle()

        assertEquals(3,emulator.cpu.registers[0])
    }

    @Test
    fun testMemorySwitch() {

        val program = ubyteArrayOf(
            0x70.toUByte(), 0x00.toUByte(),
            0x00.toUByte(), 0x00.toUByte()
        )
        for (i in program.indices){
            emulator.rom.memory[i] = program[i]
        }
        emulator.executeCycle()

        assertEquals(1, emulator.cpu.memory)
    }

    @Test
    fun testJump() {

        val program = ubyteArrayOf(
            0x50.toUByte(), 0x08.toUByte(),
            0x00.toUByte(), 0x00.toUByte()
        )
        for (i in program.indices) {
            emulator.rom.memory[i] = program[i]
        }
        emulator.executeCycle()

        assertEquals(8, emulator.cpu.programCounter)
    }

    @Test
    fun testBadJump() {

        val program = ubyteArrayOf(
            0x50.toUByte(), 0x07.toUByte(),
            0x00.toUByte(), 0x00.toUByte()
        )
        for (i in program.indices) {
            emulator.rom.memory[i] = program[i]
        }
        val exception = assertFailsWith<IllegalArgumentException> {
            emulator.executeCycle()
        }
        assertEquals("Error: Jump address 7 is not divisible by 2", exception.message)
    }
}