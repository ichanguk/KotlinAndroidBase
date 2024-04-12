// 3. 1부터 100까지의 수중에서 7의 배수의 합을 구하는 함수를 만드시오

fun sum7Multiplies(): Int {
    var sum: Int = 0
    var i = 7
    while (i <= 100) {
        sum += i
        i += 7
    }
    return sum
}

println(sum7Multiplies())