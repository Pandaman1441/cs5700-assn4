import templates.Instruction

class Convert_to_Base_10 : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        val rXValue = Emulator.cpu.registers[bytes[1]]
        val hundreds = rXValue / 100
        val tens = (rXValue / 10) % 10
        val ones = rXValue % 10

        if (Emulator.cpu.memory == 0){
            Emulator.ram.write(Emulator.cpu.address, hundreds.toUByte())
            Emulator.ram.write(Emulator.cpu.address+1, tens.toUByte())
            Emulator.ram.write(Emulator.cpu.address+2, ones.toUByte())
        }
        else {
            Emulator.rom.write(Emulator.cpu.address,hundreds.toUByte())
            Emulator.rom.write(Emulator.cpu.address+1,tens.toUByte())
            Emulator.rom.write(Emulator.cpu.address+2,ones.toUByte())
        }
        return 2
    }
}