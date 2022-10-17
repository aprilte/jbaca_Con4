fun main() {
    // write your code here
    val size = readln().toInt()
    val contents = List<Int>(size) { readln().toInt() }
    var maxIdx = 0
    for (i in 0..contents.lastIndex) {
        if (contents[maxIdx] < contents[i]) maxIdx = i
    }
    println(maxIdx)
}