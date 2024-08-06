import templates.Instruction

class Sub : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        Emulator.cpu.registers[bytes[3]] = bytes[1] - bytes[2]
        return 2
    }
}