package connectfour

fun main() {
    val conf = Con4()
    conf.matchController()
}


class Con4() {
    var playerA = "playerA"
    var playerB = "playerB"
    var row = 6
    var col = 7
    var turn = 0

    init {
        initialiser()
        var field = Array(row, {Array(col, {0})})
        println("$playerA vs $playerB")
        println("$row X $col board")
        printField()
    }

    fun matchController() {
        while(match()){}
    }

    fun match(): Boolean {
        var continuation = true
        if (turn % 2 == 0) {
            println("${playerA}'s turn")
        } else {
            println("${playerB}'s turn")
        }
        var sts = 0
        while (sts == 0) {
            sts = getItsTurn()
            if (0 < sts) {
               TODO("invoke function: putHand(0 or 1: o or *)")
            } else {
                continuation = false
            }
        }

        return continuation
    }

    fun getItsTurn(): Int{
        val input = readln()
        if(input == "end") {
            println("Game over!")
            return -1
        }
        try {
            val inputcol = input.toInt()
            if( inputcol in 1..this.col ) return inputcol
        } catch (ex: Exception) {
            println("Invalid Input")
            return 0
        }
        println("The column number is out of range (1 - ${this.col})")
        return 0
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

    fun printField() {
        //print index
        repeat(this.col){print(" ${it+1}")}
        println()
        //boxes
        for (i in 0..(this.row - 1)) {
            for (j in 0..this.col) {
                print(
                    if(j < this.col) {
                        "| "
                    } else {
                        "|"
                    }
                )
            }
            println()
        }
        //end of field
        println("=".repeat(this.col * 2 + 1))
    }
}