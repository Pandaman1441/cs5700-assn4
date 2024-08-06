import templates.*

object Emulator {
    val cpu = CPU()
    val ram = RAM()
    val rom = ROM()
    val screen = Screen()

    private val instructions: Array<Instruction?> = arrayOf(
        Store(),Add(),Sub(),Read(),
        Write(),Jump(),Read_Keyboard(),Switch_Memory(),
        Skip_Equal(),Skip_Not_Equal(),Set_A(),Set_T(),
        Read_T(),Convert_to_Base_10(),Convert_Byte_to_ASCII(),Draw()
    )



    fun start(){
        //Stuff
        rom.loadProgram("roms/addition.out")
        executeCycle()
    }

    fun executeCycle(){
        //stuff
        while (cpu.programCounter < 36) {
            val nibbles = cpu.fetchInstruction(rom)
            if (nibbles[0] == 0 && nibbles[1] == 0){
                end()
            }
            else {
                instructions[nibbles[0]]?.processInstruction(nibbles)
            }
        }
    }

    fun end(){
        //stuff
    }
}