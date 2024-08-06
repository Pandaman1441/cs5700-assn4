

class Screen {
    val height = 8
    val width = 8
    var grid: Array<CharArray> = Array(height){ CharArray(width) { '\u0000' }}

    fun display(){
        for (row in grid){
            println(row.joinToString(""))
        }
        println("#".repeat(width))
        println()
    }

    fun writeChar( character: Char, x: Int, y: Int){
        if (x < 0 || x >= height || y < 0 || y >= width) {
            throw IllegalArgumentException("Invalid row or column")
        }
        grid[x][y] = character
    }
}