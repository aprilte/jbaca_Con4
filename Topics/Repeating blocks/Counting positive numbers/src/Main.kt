fun main() {
    // put your code here
    val count = readln().toInt()
    var counter = 0
    for (i in 1..count) {
        val vava = readln().toInt()
        if (0 < vava) counter++
    }
    print(counter)
}