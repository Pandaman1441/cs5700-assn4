package templates

abstract class Instruction {    // At fetchInstruction in the CPU we decide which instruction to call
    public fun processInstruction(instruction: Byte){
        val bytes = splitBytes(instruction)
        val increment = operation(bytes)
        adjustProgramCounter(increment)
    }
    protected abstract fun splitBytes(instruction: Byte) : IntArray
    protected abstract fun operation(bytes: IntArray) : Int
    protected abstract fun adjustProgramCounter(increment: Int)
}