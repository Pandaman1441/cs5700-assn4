

fun main(args: Array<String>){
    println("Type in the path to the rom file.")
    val input = readln()
    // start the emulator and pass the input
    println(input)
    Emulator.start()
}