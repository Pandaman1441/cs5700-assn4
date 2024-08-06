import templates.Instruction

class Sub : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        val rX = Emulator.cpu.registers[bytes[1]]
        val rY = Emulator.cpu.registers[bytes[2]]
        Emulator.cpu.registers[bytes[3]] = rX - rY
        return 2
    }
}