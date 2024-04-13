fun addTwoNumbers(number1: Int, number2: Int): Int {
    return number1 + number2
}

// 고차 함수
fun addTenNine(function: (Int, Int) -> Int) {
    val result: Int = function(10, 9)
    println("결과는 $result 입니다")
}

addTenNine(::addTwoNumbers)

// 람다
// 풀버전(생략이 없는 버전)
val addTenNine2: (Int, Int) -> Int = { number1: Int, number2: Int ->
    val result = number1 + number2
    result // 람다함수에서는 return을 안 적고 마지막 줄이 자동으로 리턴됨
}

val addTenNine3: (Int, Int) -> Int = { number1: Int, number2: Int ->
    number1 + number2
}

println(addTenNine2(2, 3))
println(addTenNine3(2, 3))

addTenNine(addTenNine2) // 람다함수를 인자로 사용하는 경우에는 ::를 사용할 필요가 없다.

// 생략 버전 1(number1과 number2는 Int인게 추론되므로 생략)
val addTenNine4: (Int, Int) -> Int = { number1, number2 ->
    number1 + number2
}

addTenNine(addTenNine4)

// 생략 버전 2(저장하는 변수의 자료형을 생략한 버전)
val addTenNine5 = { number1: Int, number2: Int ->
    number1 + number2
}

// 너무 간단한 경우 ()없이 바로 {}에 람다함수 입력
addTenNine {number1, number2 -> number1 + number2}

// 파라미터가 없는 람다 함수
val addTenNine6: () -> Int = {
    10 + 9
}

// 파라미터가 한 개인 경우에는 It을 사용한다
val addTenNine7: (Int) -> Int = {
    it + 9
}

println(addTenNine7(10))