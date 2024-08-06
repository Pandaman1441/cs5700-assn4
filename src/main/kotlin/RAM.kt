


class RAM {
    @OptIn(ExperimentalUnsignedTypes::class)
    val memory: UByteArray = UByteArray(4096)


    fun read(address: Int): UByte{
        TODO()
    }

    fun write(address: Int, value: UByte){
        //stuff
    }

    fun clearMemory(){
        //stuff
    }
}