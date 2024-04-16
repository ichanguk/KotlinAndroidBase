// 계산기3
//- 사칙연산을 할 수 있는 1개의 함수 구현
//- 한번에 여러가지의 연산을 입력 받을 수 있어야 한다
//- ex> 더하기3 더하기5 나누기10 곱하기2
//- ex> calculater.calculate(더하기3, 더하기5, 빼기2, 나누기5)

class Calculator (initNum: Int = 0) {
    var result: Int = 0
        set(value) {
            field = value
            println("계산결과 = " + result + "입니다")
        }

    init {
        result = initNum
    }

    fun calculate(operators: List<Char>, operands: List<Int>) {
        operators.forEachIndexed { index, operator ->
            val num = operands[index]
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
}

val calculator1 = Calculator()
calculator1.calculate(listOf<Char>('?', '+', '*', '/'), listOf<Int>(5, 3, 3, 0))
