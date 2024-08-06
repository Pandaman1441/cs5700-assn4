

class CPU {
    var programCounter: Int = 0
    var timer: Int = 0
    var address: Int = 0
    var memory: Int = 0
    var registers: IntArray = IntArray(8)


    @OptIn(ExperimentalStdlibApi::class)
    fun fetchInstruction(rom: ROM) : IntArray{
        val byte1 = rom.read(programCounter).toUByte()
        val byte2 = rom.read(programCounter + 1).toUByte()
        val firstNibble = byte1.toInt() shr 4
        val secondNibble = byte1.toInt() and 0xF
        val thirdNibble = byte2.toInt() shr 4
        val fourthNibble = byte2.toInt() and 0xF
        val nibbleArray: IntArray = intArrayOf(firstNibble,secondNibble,thirdNibble,fourthNibble)

        programCounter++
        programCounter++

        return nibbleArray
    }

    fun timerTick(){
        //stuff
    }
}