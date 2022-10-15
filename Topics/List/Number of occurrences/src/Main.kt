fun solution(strings: List<String>, str: String): Int {
    // put your code here
    var num = 0
    strings.forEach{
        if(str == it) num++
    }
    return num
}