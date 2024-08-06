import templates.Instruction
import java.util.*


class Read_Keyboard : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        print("Please enter an integer (0-F): ")
        val input = readLine() ?: ""
        val validInput = input.uppercase().take(2).filter{ it in '0'..'9' || it in 'A'..'F'}
        val value = if (validInput.isEmpty()) 0 else validInput.toInt(16)
        Emulator.cpu.registers[bytes[1]] = value
        return 2
    }
}