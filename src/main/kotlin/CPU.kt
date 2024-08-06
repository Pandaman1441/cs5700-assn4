

class CPU {
    var programCounter: Int = 0
    var timer: Int = 0
    var address: Int = 0
    var memory: Int = 0
    var registers: IntArray = IntArray(8)


    @OptIn(ExperimentalStdlibApi::class)
    fun fetchInstruction(rom: ROM) : IntArray{
        //stuff     Store the instructions in an array and then when we grab the first nibble,
        //          convert it to an int and then use it to grab the correct instruction
        //          like instructions[13] would be convert_to_base_10, and then we pass the rest of the nibbles in an array
        val byte1 = rom.read(programCounter).toUByte()
        val byte2 = rom.read(programCounter + 1).toUByte()
        val firstNibble = byte1.toInt() shr 4
        val secondNibble = byte1.toInt() and 0xF
        val thirdNibble = byte2.toInt() shr 4
        val fourthNibble = byte2.toInt() and 0xF
        val nibbleArray: IntArray = intArrayOf(firstNibble,secondNibble,thirdNibble,fourthNibble)


        print("$programCounter: ")
        print(byte1.toHexString())
        print(byte2.toHexString())
        println()
        programCounter++
        programCounter++

//        println(byte1.toHexString())
//        println(firstNibble)
//        println(firstNibble == 6)
//        println(secondNibble)
//
//        println()
//        println(byte2.toHexString())
//        println(thirdNibble.toHexString())
//        println(fourthNibble.toHexString())
        return nibbleArray
    }

    fun timerTick(){
        //stuff
    }
}