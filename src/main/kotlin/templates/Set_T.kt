import templates.Instruction

class Set_T : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        var newByte = instruction[1] shl 4
        newByte = newByte or instruction[2]
        val newInstruction: IntArray = intArrayOf(instruction[0],newByte)
        return newInstruction
    }

    override fun operation(bytes: IntArray): Int {
        Emulator.cpu.timer = bytes[1]
        return 2
    }
}