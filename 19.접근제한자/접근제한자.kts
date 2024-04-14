// Scope

var number: Int = 1

fun changeNumber() {
    var internalNumber: Int = 2
    number = 20 // 하위 스코프에서 상위 멤버에 접근할 수 있다
    var number: String = "재정의" // 하위 스코프에서 상위 멤버를 재정의할 수 있다.
    println(number)
}

changeNumber()
println(number)

// internalNumber = 30 // 상위 스코프에서 하위 스코프 멤버에 접근할 수 없다

// 접근 제한자
class Numbers(private var number: Int = 10) {
    fun changeNumber() {
        this.number = 100 // Numbers라는 스코프 안에 존재하기 때문에 접근 가능
    }
    fun whatIsNumber(): Int {
        return this.number
    }
}

val numbers = Numbers()
//println(numbers.number) // numbers의 number가 private이라 접근 불가
//numbers.number = 100
//println(numbers.number)

println(numbers.whatIsNumber())