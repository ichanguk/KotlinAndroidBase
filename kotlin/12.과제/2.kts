// 2. 1부터 주어진 숫자까지의 합을 구하는 함수를 만들어 보자

fun sum1toN(N: Int): Int {
    var sum: Int = 0
    for (i in 1..N) {
        sum += i
    }
    return sum
}

println(sum1toN(10))