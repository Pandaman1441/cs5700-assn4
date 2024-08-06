import templates.Instruction

class Skip_Not_Equal : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        val rX = Emulator.cpu.registers[bytes[1]]
        val rY = Emulator.cpu.registers[bytes[2]]
        return if (rX != rY){
            4
        } else{
            2
        }
    }
}