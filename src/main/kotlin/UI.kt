

fun main(args: Array<String>){
    println("Type in the path to the rom file.")
    val input = readln()
    Emulator.start(input)
}