import templates.Instruction

class Jump : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        var secondByte = instruction[2] shl 4
        secondByte = secondByte or instruction[3]
        val jValue = (instruction[1] shl 8) or secondByte
        val newArray: IntArray = intArrayOf(instruction[0],jValue)
        return newArray
    }

    override fun operation(bytes: IntArray): Int {
        val jumpAddress = bytes[1]

        if(jumpAddress % 2 != 0){
            throw IllegalArgumentException("Jump address $jumpAddress is not divisible by 2")
        }
        else{
            Emulator.cpu.programCounter = jumpAddress
        }
        return 0
    }
}