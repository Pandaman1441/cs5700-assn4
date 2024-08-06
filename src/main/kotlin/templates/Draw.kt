import templates.Instruction

class Draw : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        val rX = bytes[1]
        val rXValue = Emulator.cpu.registers[rX]

        if (rXValue > 0x7F) {
            throw IllegalArgumentException("Value in r$rX is greater than 0x7F")
        }
        val character = rXValue.toChar()
        Emulator.screen.writeChar(character,bytes[2],bytes[3])
        Emulator.screen.display()
        return 2
    }
}