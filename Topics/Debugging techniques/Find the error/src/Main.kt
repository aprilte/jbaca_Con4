import java.util.Scanner

fun swapInts(ints: IntArray): IntArray {
    return intArrayOf(ints[1], ints[0])
}

fun main() {
    val scanner = Scanner(System.`in`)
    while (scanner.hasNextLine()) {
        var ints = intArrayOf(
            scanner.nextLine().toInt(),
            scanner.nextLine().toInt(),
        )
        val intt = swapInts(ints)
        println(intt[0])
        println(intt[1])
    }
}