// 5. nullable 정수형 두개를 받는 함수를 만든다. 이 함수는 받은 인수의 합을 반환한다
//   이때 인수중에 null 이 있으면 0으로 취급하여 합을 구한다

fun sumInt(a: Int?, b: Int?):Int {
    if (a == null && b == null) {
        return 0
    } else if (a == null) {
        return b!!
    } else if (b == null) {
        return a
    } else {
        return a + b
    }
}

println(sumInt(a = null, b = 5))
println(sumInt(a = 5, b = null))
println(sumInt(a = null, b = null))
println(sumInt(a = 5, b = 5))