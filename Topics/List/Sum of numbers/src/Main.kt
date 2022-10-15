fun solution(numbers: List<Int>): Int {
    // put your code here
    var sum = 0
    numbers.forEach {
        sum += it
    }
    return sum
}