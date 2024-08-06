import java.io.File

@OptIn(ExperimentalUnsignedTypes::class)
class ROM {
    val memory: UByteArray = UByteArray(4096)

    fun loadProgram(path: String){
        //stuff
        val file = File(path)
        val program = file.readBytes()
        for (i in program.indices){
            memory[i] = program[i].toUByte()
        }
    }

    fun read(address: Int): UByte {
        //stuff
        return memory[address]
    }

    fun clearMemory(){
        //stuff
    }

    fun write(address: Int, value: UByte){
        println("Attempted to write to ROM")
    }
}