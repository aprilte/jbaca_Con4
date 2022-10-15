fun solution(numbers: List<Int>) {
    // put your code here
    var ret = listOf<Int>().toMutableList()
    numbers.forEach {
        if( it % 2 == 0 ) ret.add(it)
    }
    println(ret.joinToString(" "))
}