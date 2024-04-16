// 9. 단수를 입력 받아 해당 단수의 값을 리스트로 출력하는 함수를 만드시오
//   fun abc(3)
//   ->[3,6,9,12,15,18,21,24,27]

fun printMultiplicationTable(N:Int) {
    var result: MutableList<Int> = mutableListOf<Int>()
    for (i in 1..9) {
        result.add(i - 1, i * N)
    }
    print(result)
}

printMultiplicationTable(3)