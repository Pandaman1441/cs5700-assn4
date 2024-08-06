package templates

import Emulator

abstract class Instruction {    // At fetchInstruction in the CPU we decide which instruction to call
    public fun processInstruction(instruction: IntArray){
        val bytes = organizeBytes(instruction)
        val increment = operation(bytes)
        adjustProgramCounter(increment)
    }
    protected abstract fun organizeBytes(instruction: IntArray) : IntArray
    protected abstract fun operation(bytes: IntArray) : Int
    fun adjustProgramCounter(increment: Int){
        Emulator.cpu.programCounter += increment
    }
}