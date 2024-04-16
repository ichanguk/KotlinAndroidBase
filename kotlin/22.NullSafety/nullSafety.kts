// ?
val number: Int = 10    // Non-Nullable Int
val number: Int? = null // Nullable Int

// !!(정말 필요한 경우에만 사용해야 한다)
val nullableNumberList: List<Int?> = listOf<Int?>(1, 2, 3, null, null)
var result: Int = 0
//nullableNumberList.forEach {
//    result += it!!  // 실제론 null이 들어가있어서 런타임 오류남
//}

// ?.(safe call)
val text: String? = "text"
//println(text.length) // 오류남, text가 nullable이라서
println(text?.length)

// !!. (마찬가지로 사용하지 않는 것이 좋음)
// println(text!!.length)

// as?
open class Warrior1(var name: String, var power: Int, var type: String) { // 부모 클래스, 슈퍼클래스
    fun attack() {
        println("복잡한 코드 + 공격")
    }
}

// 상속 끊어놓은 상태
class DefenseWarrior1 constructor(name: String, power: Int) {
    fun defense() {
        println("방어")
    }
}

val defenseWarrior = DefenseWarrior1("", 100)
//val warrior = defenseWarrior as Warrior1 // 에러 발생
val warrior = defenseWarrior as? Warrior1
println(warrior) // null 출력

// ?: 엘비스 연산
val text2: String? = "123"
val nullText: String? = null

var len1: Int = if (text2 != null) text2.length else 0
var len2: Int = text2?.length ?: 0 // 위와 같은 코드
