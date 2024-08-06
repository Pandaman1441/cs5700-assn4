package templates

class Add : Instruction() {
    override fun splitBytes(instruction: Byte): IntArray {
        println("spliting bytes")
        val bytes = IntArray(3)
        val rX: Int
        val rY: Int
        val rZ: Int
        TODO()
    }

    override fun operation(bytes: IntArray): Int {
        TODO("Not yet implemented")
    }

    override fun adjustProgramCounter(increment: Int) {
        TODO("Not yet implemented")
    }

}

