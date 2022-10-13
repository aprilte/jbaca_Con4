val regex = Regex("[1-9][0-9]? rings?")


fun main () {
    val redaa = readln()
    println(regex.matches(redaa))
}