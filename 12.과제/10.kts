// 10. 숫자 리스트 두개를 넣어주면 짝수 홀수로 분리된 Map을 만드는 함수를 만드시오
//   (Map의 키는 짝수의 경우 "짝수", 홀수의 경우 "홀수" 한다)

fun classifyNumbersByParity(A:List<Int>, B:List<Int>):MutableMap<String, List<Int>> {
    var numList:MutableList<Int> = mutableListOf()
    numList.addAll(A)
    numList.addAll(B)

    var result:MutableMap<String, List<Int>> = mutableMapOf()
    var evenNums:MutableList<Int> = mutableListOf()
    var oddNums:MutableList<Int> = mutableListOf()
    numList.forEach{
        if (it % 2 == 0) {
            evenNums.add(it)
        } else {
            oddNums.add(it)
        }
    }
    result.put("짝수", evenNums)
    result.put("홀수", oddNums)
    return result
}

println(
    classifyNumbersByParity(listOf<Int>(1, 2, 3, 4, 5), listOf<Int>(6, 7, 8, 9, 10))
)