import templates.Instruction

class Read_T : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        Emulator.cpu.registers[bytes[1]] = Emulator.cpu.timer
        return 2
    }
}