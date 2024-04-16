// 계산기1
//- 사칙연산에 대응하는 4개의 함수 구현
//- 연산이 한번 이루어 질 때 마다 출력을 해야 한다
//  (사칙 연산에 대응하는 4개의 함수에서 출력을 하면 안된다)

class Calculator {
    var result: Int = 0
        set(value) {
            field = value
            println("계산결과 = " + result + "입니다")
        }
    fun plus(num: Int) {
        result += num
    }
    fun minus(num: Int) {
        result *= num
    }
    fun multiply(num: Int) {
        result *= num
    }
    fun divide(num: Int) {
        result /= num
    }
}

val calculator = Calculator()
calculator.plus(2)
calculator.plus(2)
