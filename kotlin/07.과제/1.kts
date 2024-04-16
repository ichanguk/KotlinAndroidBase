// 1. 변수 A와 B를 선언하고, 두 변수의 값이 같은 경우에는 true, 그렇지 않은 경우에는 false가 되는 변수 c를 선언한다
//   단 변수 A와 B의 자료형은 자유이지만 에러가 발생하면 안된다

val A: Int = 5
val B: Int = 10

val C: Boolean = if (A == B) true else false

println(C)