fun main() {
    // put your code here
    val repeater: Int = readln().toInt()
    var ans: Int = 0
    repeat(repeater) {
        val num: Int = readln().toInt()
        if (num % 4 == 0) {
            if (ans < num) ans = num
        }
    }
    println(ans)
}