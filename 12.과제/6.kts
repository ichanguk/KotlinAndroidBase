// 6. 두개의 주사위를 던졌을때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 함수를 만드시오
//   -> [[3,3],[1,5],...]

fun printNumOfSum6Case() {
    var result = mutableListOf<List<Int>>()

    for (i in 1..6) {
        for (j in 1..6) {
            if (i + j == 6) {
                result.add(listOf<Int>(i, j))
            }
        }
    }
    println(result)
}

printNumOfSum6Case()