// if
val number1: Int = 10

if (number1 == 10) {
    println("10 입니다")
} else if (number1 == 20) {
    println("20 입니다")
} else {
    println("10, 20 둘 다 아닙니다.")
}

if (number1 == 10) println("10입니다")
else if (number1 == 20) println("20입니다")
else println("10, 20 둘다 아닙니다")

val number2: Int = 10 + 20
val number3: Int = if (number2 > 30) 40 else 50 // 코틀린에서는 이 if else를 표현이 아니라 식으로 취급
println(number3)

//val number4: Int = (number2 > 30)? 40 : 50 //이렇게는 못씀

// when
var number4: Int = 5
when (number4) {
    5 -> {
        println("5입니다")
    }
    6 -> {
        println("6입니다")
    }
    else -> {
        println("모르겠습니다")
    }
}

// 중괄호 생략가능, else없어도됨
when (number4) {
    5 -> println("5입니다")
    6 -> println("6입니다")
}

// 케이스와 조건의 타입은 같아야함
//when (number4) {
//    4 -> println("number is 4")
//    "안녕하세요" -> println("안녕")
//    is Boolean -> println("boolean")
//} // 오류남

number4 = 10
// 조건을 모두 boolean으로 맞춰줄수도 있음
when (number4) {
    in 1..10 -> println("number is in 1..10")
    in 20..30 -> println("number is in 20..30")
}