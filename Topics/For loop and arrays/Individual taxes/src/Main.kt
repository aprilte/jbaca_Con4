fun main() {
    // write your code here
    val size = readln().toInt()
    val compani = List<Int>(size) { readln().toInt() }
    val taxperc = List<Int>(size) { readln().toInt() }
    val tax = List<Int>(size) { compani[it] * taxperc[it] }
    var mtc = 0
    for (i in 0..tax.lastIndex) {
        if (tax[mtc] < tax[i]) mtc = i
    }
    println(mtc + 1)
}