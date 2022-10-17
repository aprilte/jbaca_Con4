fun main() {
    // write your code here
    val content = readln().toInt()
    val contents = List<Int>(content){readln().toInt()}
    print("${contents.last()} ")
    for (i in 0..contents.lastIndex - 1){
        print("${contents[i]} ")
    }
}