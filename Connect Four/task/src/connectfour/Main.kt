package connectfour

fun main() {
    val Conf = Con4()
}

class Con4() {
    var playerA = "playerA"
    var playerB = "playerB"
    var row = 6
    var col = 7

    init {
        initialiser()
        var field = Array(row, {Array(col, {0})})
        println("$playerA vs $playerB")
        println("$row X $col board")
    }

    fun initialiser() {
        println("Connect Four\nFirst player's name:")
        playerA = readln()
        println("Second player's name:")
        playerB = readln()
        while(setMap()){
        }
    }

    fun setMap(): Boolean{
        var continuation = true
        val validMat = Regex("[\\s\\t]*?[0-9]+[\\s\\t]*?[xX][\\s\\t]*?[0-9]+[\\s\\t]*?")
        println("Set the board dimensions (Rows x Columns)\nPress Enter for default (6 x 7)")
        var readda = readln()
        if(readda == "") readda = "6x7"
        if (validMat.matches(readda)) {
            val spdata = readda.replace(" ", "").replace("\t", "").split("x","X")
            if (spdata.first().toInt() in 5..9 && spdata.last().toInt() in 5..9) {
                row = spdata.first().toInt()
                col = spdata.last().toInt()
                continuation = false
            } else if(!(spdata.first().toInt() in 5..9)) {
                println("Board rows should be from 5 to 9")
            } else { println("Board columns should be from 5 to 9") }
        } else { println("Invalid input") }
        return continuation
    }

}