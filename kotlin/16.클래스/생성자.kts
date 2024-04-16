// 클래스를 선언하는 방법
class Person {}

// 생성자
// 주 생성자
// - 클래스 이름 옆에 괄호로 둘러싸인 코드
// - 클래스를 통해서 개겣를 만드는 데 필요한 재료를 적어준다.
// - 변수명: 변수타입
// - 반드시 한 개만 존재할 수 있다.
// - constructor 키워드를 생략할 수 있다

// 주 생성자 -> 풀 버전 (생략이 없는 버전)
class User1 constructor(name: String) {
    val userName: String // 클래스 속성(property)은 init 블럭에서 초기화 되서 바로 초기화를 안해줘도 됨
    init { // 클래스가 생성될 때 호출
        println(name)
        userName = name
    }
}

// 클래스를 호춣 -> 인스턴스화 (Instance)
// 객체 -> Object, Instance
val user = User1("홍길동") // User1의 init호출

// 주 생성자 -> init을 생략하는 방법(클래스 속성을 모두 초기화 해주기)
class User2 constructor(name: String) {
    val userName: String = name
}

// 주 생성자 -> constructor를 생략하는 방법
class User3(name: String) {
    val userName:String = name
}

// 주 생성자 -> 기본값
class User4(name: String = "김아무개") {
    val userName: String = name
}
val user = User4()

// 생성자의 속성이 여러개인 경우
class User5(age: Int, name: String) {
    val age: Int
    val name: String

    init {
        this.age = age
        this.name = name
    }
}

val user5 = User5(20, "홍길동")
println(user5.age)

// 주 생성자 -> 생략할 수 있는 모든 걸 생략하는 방법
class User6(val userName: String) {
}


// 부 생성자 (Secondary Constructor)
// - constructor 키워드를 생략할 수 없다.
// - 객체를 만들기 위한 옵션 조건이 있다.
// - 부 생성자에는 주 생성자에서 필요한 조건을 포함하고 있어야 한다.
// - 부 생성자는 주 생성자에게 생성을 위임해야 한다.
class User7 constructor(name: String) {
    var age: Int = 0    // 부생성자에서만 쓰더라도 일단 초기화는 해야 함
    val name: String
    var nickName: String = ""

    init {
        println("init")
        this.name = name
    }
    // 부 생성자는 클래스명 우측에 올 수 없다. -> 클래스의 본문에 있어야 한다
    constructor(name: String, age: Int) : this(name){
        println("second")
        this.age = age // init으로 생성하는 게 아니라서 age는 var이어야 함
    }

    // 부 생성자는 복수 개 존재할 수 있다.
    constructor(name: String, age: Int, nickName: String) : this(name){
        this.age = age
        this.nickName = nickName
    }
}

val user7 = User7(name = "가나다")
println(user7.name)


val user72 = User7("가나다", 50)
println(user72.age)

// 실행 순서
// 부 생성자 호출 -> 부 생성자 안에 있는 주 생성자 호출 -> init 호출 -> 부 생성자 본문 실행

class User8 {
    val age: Int
    val name: String

    // 주 생성자가 없는 것처럼 보이고 부 생성자만 있을 때 부 생성자가 주 생성자처럼 보인다
    // -> 부 생성자가 맞다!
    // -> 주 생성자는 코틀린이 자동으로 만들어 준 것이다.
    // -> 주 생성자가 없기 때문에 this() 생성자를 이용해 생성을 위임할 필요가 없다
    constructor(age: Int, name: String) {
        this.age = age
        this.name = name
    }
}

val user8 = User8(10, "가가가")
println(user8.age)