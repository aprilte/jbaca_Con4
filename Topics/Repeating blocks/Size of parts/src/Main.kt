fun main() {
    // put your code here
    val repeater: Int = readln().toInt()
    var retArray = Array(3) { 0 * it }
    repeat(repeater) {
        val readVal: Int = readln().toInt()
        when (readVal) {
            0 -> retArray[0] = retArray[0]?.plus(1)
            1 -> retArray[1] = retArray[1]?.plus(1)
            -1 -> retArray[2] = retArray[2]?.plus(1)
        }
    }
    retArray.forEach {
        print("$it ")
    }
}

