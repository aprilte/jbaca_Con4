fun main() {
    val answer = readln()
    // write your code here
    val regEx = Regex("I can'?t? do my homework on time!")
    println(regEx.matches(answer))
}