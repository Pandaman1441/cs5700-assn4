import templates.Instruction

class Store : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        var newByte = instruction[2] shl 4
        newByte = newByte or instruction[3]
        val newInstruction: IntArray = intArrayOf(instruction[0],instruction[1],newByte)
        return newInstruction
    }
    override fun operation(bytes: IntArray): Int {
        Emulator.cpu.registers[bytes[1]] = bytes[2]
        return 2
    }
}