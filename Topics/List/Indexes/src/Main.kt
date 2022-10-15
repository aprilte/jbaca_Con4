fun solution(products: List<String>, product: String) {
    // put your code here
    products.withIndex().forEach{
        if (it.value == product) print("${it.index} ")
    }
}