import templates.Instruction

class Read : Instruction() {
    override fun organizeBytes(instruction: IntArray): IntArray {
        return instruction
    }

    override fun operation(bytes: IntArray): Int {
        if(Emulator.cpu.memory == 0){
            Emulator.cpu.registers[bytes[1]] = Emulator.ram.read(Emulator.cpu.address).toInt()
        }
        else{
            Emulator.cpu.registers[bytes[1]] = Emulator.rom.read(Emulator.cpu.address).toInt()
        }
        return 2
    }
}