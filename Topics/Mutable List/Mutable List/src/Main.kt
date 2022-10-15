fun names(namesList: List<String>): List<String> {
    var count = 0
    val nameCount = mutableListOf<String>()
    //
    val distinct = namesList.distinct()
    distinct.forEach {
        val name = it
        count = namesList.filter { name == it }.size
        nameCount.add("The name $name is repeated $count times")
    }
    // add your code here
    //
    return nameCount
}