package templates


class Set_A : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        var secondByte = instruction[2] shl 4
        secondByte = secondByte or instruction[3]
        val jValue = (instruction[1] shl 8) or secondByte
        val newArray: IntArray = intArrayOf(instruction[0],jValue)
        return newArray
    }

    override fun operation(bytes: IntArray): Int {
        Emulator.cpu.address = bytes[1]
        return 2
    }
}