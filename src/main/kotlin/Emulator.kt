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
    private val timerExecutor = Executors.newSingleThreadScheduledExecutor()

    fun start(input: String){
        rom.loadProgram(input)

        val cpuRunnable = Runnable {
            executeCycle()
        }
        val timerRunnable = Runnable {
            cpu.timerTick()
        }

        val cpuFuture = executor.scheduleAtFixedRate(
            cpuRunnable,
            0,
            1000L / 500L,
            TimeUnit.MILLISECONDS
        )
        val timerFuture = timerExecutor.scheduleAtFixedRate(
            timerRunnable,
            0,
            16,
            TimeUnit.MILLISECONDS
        )

        try{
            cpuFuture.get()
        }catch (_: Exception){
            executor.shutdown()
            timerExecutor.shutdown()
        }

    }

    fun executeCycle(){
        val nibbles = cpu.fetchInstruction(rom)
        println(nibbles.joinToString("") {it.toString(16)})
        val r0 = Emulator.cpu.registers[0]
        try {
            if (nibbles.joinToString("") {it.toString(16)} == "0000"){
                end()
            }
            else {
                instructions[nibbles[0]]?.processInstruction(nibbles)
            }
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
            end()
        }
    }

    fun end(){
        executor.shutdown()
        timerExecutor.shutdown()
        println("Goodbye")
    }
}