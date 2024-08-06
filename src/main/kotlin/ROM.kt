import java.io.File


class ROM {
    val memory: ByteArray = ByteArray(4096)

    fun loadProgram(path: String){
        //stuff
        val file = File(path)
        val program = file.readBytes()
        System.arraycopy(program,0,memory,0, program.size)
    }

    fun read(address: Int): Byte{
        //stuff
        return memory[address]
    }

    fun clearMemory(){
        //stuff
    }

    fun write(address: Int, value: Byte){
        println("Attempted to write to ROM")
    }
}