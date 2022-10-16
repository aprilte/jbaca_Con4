package connectfour

fun main() {
    val conf = Con4()
    conf.matchController()
}


class Con4() {
    var playerA = "playerA"
    var playerB = "playerB"
    var scoreA = 0
    var scoreB = 0
    var restGames = 1
    var gamesNum = 1
    var singleMode = true
    var row = 6
    var col = 7
    var turn = 0
    var field = Array(10, {Array(10, {0})})

    init {
        initialiser()
        println("$playerA vs $playerB")
        println("$row X $col board")
        if (restGames == 1) {
            println("Single game")
        } else {
            println("Total ${restGames} games")
        }

    }

    fun matchController() {
        while (1 <= restGames) {
            if (!singleMode) println("Game #${gamesNum}")
            printField()
            while (match()) {
            }
        }
        println("Game over!")
    }

    fun match(): Boolean {
        var continuation = true
        var inputCol = 0

        while (inputCol == 0) {
            if (turn % 2 == 0) {
                println("${playerA}'s turn")
            } else {
                println("${playerB}'s turn")
            }

            inputCol = getItsTurn()
            if (0 < inputCol) {
                putHand(turn, inputCol)
            } else if (inputCol < 0) {
                //forcibly halt
                continuation = false
                restGames = 0
                return continuation
            } else {
                continuation = false
            }
        }
        val match = checkMatch()
        if ( match == 1 ) {
            println("Player $playerA won")
            scoreA += 2
            continuation = false
        } else if ( match == -1) {
            println("Player $playerB won")
            scoreB += 2
            continuation = false
        } else if ( match == 99) {
            println("It is a draw")
            scoreA += 1
            scoreB += 1
            //turn = 0
            continuation = false
        }

        if(!continuation && !singleMode){
            println("Score\n$playerA: $scoreA $playerB: $scoreB")
            nextGame()
            resetField()
        }
        if(!continuation && singleMode){
            nextGame()
        }
        return continuation
    }

    fun nextGame() {
        gamesNum++
        restGames--
    }
    fun resetField() {
        for (i in 0..row - 1) {
            for (j in 0.. col -1) {
                field[i][j] = 0
            }
        }
    }

    fun putHand(turn: Int, column:Int) {
        for(i in (row - 1) downTo 0) {
            if (field[column - 1][i] == 0) {
                field[column - 1][i] =
                    if ( turn % 2 == 0) {
                        1
                    } else {
                        -1
                    }
                printField()
                this.turn++
                return
            }
        }
        println("Column $column is full")
    }

    fun getItsTurn(): Int{
        val input = readln()
        if(input == "end") {
            return -1
        }
        try {
            val inputcol = input.toInt()
            if( inputcol in 1..this.col ) return inputcol
        } catch (ex: Exception) {
            println("Incorrect Column number")
            return 0
        }
        println("The column number is out of range (1 - ${this.col})")
        return 0
    }

    fun checkMatch(): Int {
        for (i in 0 .. this.row) {
            for(j in 0..this.col - 3) {
                if(field[i][j] != 0 && field[i][j] == field[i][j+1] && field[i][j+1] == field[i][j+2] && field[i][j+2] == field[i][j+3]){
                    return field[i][j]
                }
            }
        }
        for (i in 0 .. this.row - 3) {
            for(j in 0..this.col) {
                if(field[i][j] != 0 && field[i][j] == field[i+1][j] && field[i+1][j] == field[i+2][j] && field[i+2][j] == field[i+3][j]){
                    return field[i][j]
                }
            }
        }
        for (i in 0..this.col -3) {
            for(j in 0..this.row-3) {
                if(field[i][j] != 0 && field[i][j] == field[i+1][j+1] && field[i+1][j+1] == field[i+2][j+2] && field[i+2][j+2] == field[i+3][j+3]){
                    return field[i][j]
                }
            }
        }
        for (i in 0..this.col -3) {
            for(j in 3..this.row) {
                if(field[i][j] != 0 && field[i][j] == field[i+1][j-1] && field[i+1][j-1] == field[i+2][j-2] && field[i+2][j-2] == field[i+3][j-3]){
                    return field[i][j]
                }
            }
        }
        var counter = 1
        for (i in 0..this.row - 1) {
            for (j in 0..this.col -1) {
                if(field[i][j] == 0) counter = 0
            }
        }
        if(counter != 0) return 99
        return 0
    }

    fun initialiser() {
        println("Connect Four\nFirst player's name:")
        playerA = readln()
        println("Second player's name:")
        playerB = readln()
        while(setMap()){
        }

        var validGameCount = false
        while(!validGameCount) {
            println("Do you want to play single or multiple games?")
            println("For a single game, input 1 or press Enter")
            println("Input a number of games:")
            val inputKey = readln()
            if (inputKey == "") {
                validGameCount = true
            } else {
                try {
                    val inputGameNum = inputKey.toInt()
                    if (1 <= inputGameNum) {
                        restGames = inputGameNum
                        if (1 < restGames) singleMode = false
                        validGameCount = true
                    } else {
                        throw java.lang.Exception("invalid input except")
                    }
                } catch (ex: Exception) {
                    //invalid numbers
                    println("Invalid input")
                }
            }
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
                    if (j < this.col) {
                        when(field[j][i]) {
                            0 -> "| "
                            1 -> "|o"
                            -1 -> "|*"
                            else -> "| "
                        }
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