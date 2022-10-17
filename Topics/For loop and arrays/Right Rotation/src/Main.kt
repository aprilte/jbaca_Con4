fun main() {
    // write your code here
    val content = readln().toInt()
    val contents = List<Int>(content){ readln().toInt() }
    val shifter = readln().toInt() % content
    if (shifter == 0) {
        println(contents.joinToString(" "))
    } else {
        for (i in content - shifter..contents.lastIndex) {
            print("${contents[i]} ")
        }
        for (i in 0..content - shifter - 1) {
            print("${contents[i]} ")
        }
    }
}