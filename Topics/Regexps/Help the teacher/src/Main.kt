fun main() {
    val report = readLine()!!
    //write your code here.
    val regEx = Regex("[0-9] wrong answers?")
    println(regEx.matches(report))

}