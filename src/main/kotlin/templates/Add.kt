package templates

import Emulator

class Add : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        Emulator.cpu.registers[bytes[3]] = bytes[1] + bytes[2]
        return 2
    }

    override fun adjustProgramCounter(increment: Int) {
        Emulator.cpu.programCounter += increment
    }
}

