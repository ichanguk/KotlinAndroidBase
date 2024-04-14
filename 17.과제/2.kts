import kotlin.Exception

// 계산기2
//- 사칙 연산을 할 수 있는 1개의 함수 구현
//  ex) calculater.calculate('+', 10)
//  ex) calculater.calculate('-', 50)
//- 초기값을 할당 할 수 있어야 하며 초기 값을 할당 하지 않은 경우에는 0 을 기본값으로 사용한다
//- 불가능한 연산을 요청한 경우 "잘못된 연산 입니다"를 출력 한다

class Calculator (initNum: Int = 0) {
    var result: Int = 0
        set(value) {
            field = value
            println("계산결과 = " + result + "입니다")
        }

    init {
        result = initNum
    }

    fun calculate(operator: Char, num: Int) {
        try {
            when (operator) {
                '+' -> result += num
                '-' -> result -= num
                '/' -> result /= num
                '*' -> result *= num
                else -> throw Exception("잘못된 연산 입니다")
            }
        } catch (exception: Exception) {
            println("잘못된 연산 입니다")
        }
    }

}

val calculator1 = Calculator()
calculator1.calculate('?', 2)
calculator1.calculate('+', 3)
calculator1.calculate('*', 3)
calculator1.calculate('/', 0)

val calculator2 = Calculator(5)
calculator2.calculate('-', 2)