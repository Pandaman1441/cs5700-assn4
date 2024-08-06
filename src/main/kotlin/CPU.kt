

class CPU {
    var programCounter: Int = 0
    var timer: Int = 0
    var address: Int = 0
    var memory: Int = 0
    var registers: IntArray = IntArray(8)


    fun fetchInstruction(rom: ROM) : IntArray{
        val byte1 = rom.read(programCounter)
        val byte2 = rom.read(programCounter + 1)
        val firstNibble = byte1.toInt() shr 4
        val secondNibble = byte1.toInt() and 0xF
        val thirdNibble = byte2.toInt() shr 4
        val fourthNibble = byte2.toInt() and 0xF
        val nibbleArray: IntArray = intArrayOf(firstNibble,secondNibble,thirdNibble,fourthNibble)

        return nibbleArray
    }

    fun timerTick(){
        if (timer > 0){
            timer--
        }
    }
}