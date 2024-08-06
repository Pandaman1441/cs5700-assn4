import templates.Instruction

class Write : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        val registerValue = Emulator.cpu.registers[bytes[1]]
        val address = Emulator.cpu.address
        if(Emulator.cpu.memory == 0) {
            Emulator.ram.write(address, registerValue.toUByte())
        }
        else{
            Emulator.rom.write(address, registerValue.toUByte())
        }
        return 2
    }
}