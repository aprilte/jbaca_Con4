fun main() {
    // put your code here
    val count = readln().toInt()
    var grades = arrayListOf<Int>(0,0,0,0)
    repeat( count ) {
        val check = readln().toInt()
        when ( check ){
            2, -> grades[0] += 1
            3, -> grades[1] += 1
            4, -> grades[2] += 1
            5, -> grades[3] += 1
            else -> nop()
        }

    }
    println("${grades[0]} ${grades[1]} ${grades[2]} ${grades[3]}")
}

fun nop() {

}