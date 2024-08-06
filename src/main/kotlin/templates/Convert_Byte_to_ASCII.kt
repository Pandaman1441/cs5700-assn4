import templates.Instruction


class Convert_Byte_to_ASCII : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        val rX = bytes[1]
        val rXValue = Emulator.cpu.registers[rX]

        if (rXValue > 0xF){
            throw IllegalArgumentException("Value in r$rX is greater than 0xF")
        }
        val asciiValue = if (rXValue in 0..9){
            rXValue + 0x30
        } else {
            rXValue + 0x37
        }

        Emulator.cpu.registers[bytes[2]] = rXValue
        return 2
    }
}