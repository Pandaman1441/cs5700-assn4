

@OptIn(ExperimentalUnsignedTypes::class)
class RAM {
    val memory: UByteArray = UByteArray(4096)


    fun read(address: Int): UByte{
        return memory[address]
    }

    fun write(address: Int, value: UByte){
        memory[address] = value
    }
}