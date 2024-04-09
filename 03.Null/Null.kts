val number: Int? = null // null이 들어갈 수 있는 변수 -> nullable 하다
println(number)

// val number2: Int = null // 오류남, null이 들어갈 수 없는 변수 -> non-null
var number2: Int? = 3 + 5
var number3: Int? = 10

// var number4: Int? = number2 + number3 // 오류남, 하나라도 nullable하면 null이 더해지는 것을 방지하기위해 더하기 안됨
// number2와 number3가 null이 아님을 확인후 non-null로 타입을 바꾸는 방법도 있음
var number4: Int? = if (number2 != null && number3 != null) {
    number2!! + number3!!
} else {
    null
}

// 비교연산은 가능하다.

if (null == 5) {
    println("same")
} else{
    println("not same")
}


if (null == null) {
    println("same")
} else{
    println("not same")
}