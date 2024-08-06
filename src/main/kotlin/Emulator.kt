import templates.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

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

    private val executor = Executors.newSingleThreadScheduledExecutor()

    fun start(input: String){
        rom.loadProgram(input)

        val cpuRunnable = Runnable {
            executeCycle()
        }

        val cpuFuture = executor.scheduleAtFixedRate(
            cpuRunnable,
            0,
            1000L / 500L,
            TimeUnit.MILLISECONDS
        )

        try{
            cpuFuture.get()
        }catch (_: Exception){
            executor.shutdown()
        }

    }

    fun executeCycle(){
        var running = true
        while (running) {
            val nibbles = cpu.fetchInstruction(rom)
            println(nibbles.joinToString("") {it.toString(16)})
            if (nibbles.joinToString("") {it.toString(16)} == "0000"){
                running = false
                end()
            }
            else {
                //instructions[nibbles[0]]?.processInstruction(nibbles)
            }
        }
    }

    fun end(){
        executor.shutdown()
        println("Goodbye")
    }
}