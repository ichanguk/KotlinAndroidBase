fun plusNumbers(firstNum: Int, secondNum: Int): Int {
    val result: Int = firstNum + secondNum
    return result
}

// 함수를 사용(호출)하는 방법
println(plusNumbers(firstNum = 10, secondNum = 20))
println(plusNumbers(10, 20))

val result: Int = plusNumbers(firstNum = 5, secondNum = 7)
println(result)

// 기본값이 있는 함수를 선언하는 방법
fun plusNumbersWithDefalut(firstNum: Int, secondNum: Int = 10): Int {
    return firstNum + secondNum
}

println(plusNumbersWithDefalut(10)) // 20

val result2: Int = plusNumbersWithDefalut(firstNum = 10)
println(result2)
val result3: Int = plusNumbersWithDefalut(firstNum = 10, secondNum = 20)
println(result3)

fun plusNumbersWithDefalut2(firstNum: Int = 20, secondNum: Int): Int {
    return firstNum + secondNum
}

println(plusNumbersWithDefalut2(secondNum = 40)) //뒷쪽 매개변수에 기본값 안주고 이렇게도 사용가능

// 반환값이 없는 함수를 선언하는 방법
fun plusNumbersWithNoReturn(firstNum: Int, secondNum: Int): Unit {
    val result: Int = firstNum + secondNum
    println(result)
}
plusNumbersWithNoReturn(100, 200)


// Unit은 생략가능
fun plusNumbersWithNoReturn2(firstNum: Int, secondNum: Int) {
    val result: Int = firstNum + secondNum
    println(result)
}

// return만 써도 됨
fun plusNumbersWithNoReturn3(firstNum: Int, secondNum: Int) {
    val result: Int = firstNum + secondNum
    println(result)
    return
}

plusNumbersWithNoReturn3(100, 200)

// 함수 선언을 간단하게 하는 방법
fun shortPlusNumbers(firstNum: Int, secondNum: Int) = firstNum + secondNum

val result10 = shortPlusNumbers(firstNum = 10, secondNum = 100)
println(result10)

// 가변인자를 갖는 함수
fun plusMultipleNumbers(vararg numbers: Int): Unit {
    println(numbers)
}

plusMultipleNumbers(1, 2, 3, 4, 5)

fun plusMultipleNumbers2(vararg numbers: Int): Unit {
    for (number in numbers) {
        println(number)
    }
}

plusMultipleNumbers2(1, 2, 3, 4, 5)