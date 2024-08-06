import templates.Instruction

class Switch_Memory : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        if (Emulator.cpu.memory == 0){
            Emulator.cpu.memory = 1
        }
        else {
            Emulator.cpu.memory = 0
        }
        return 2
    }
}