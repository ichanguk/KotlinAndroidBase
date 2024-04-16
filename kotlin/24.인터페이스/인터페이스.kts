interface Tiger {
    fun bite()
    fun goToBox()
}

class BackDoSanTiger: Tiger {
    override fun bite() {
        println("문다")
    }

    override fun goToBox() {
        println("상자에 들어간다")
    }
}

val backDoSanTiger: BackDoSanTiger = BackDoSanTiger()
backDoSanTiger.bite()   // interface만 보고도 이러한 기능을 할 수 있음을 알 수 있음
backDoSanTiger.goToBox()

interface Person {
    // 멤버들의 구현부가 없다
    var dress: String
    fun eat()
    fun sleep() {   // interface에서 구현부를 만들어 둘 수도 있음
        println("잠을 잔다")
    }
}

open class Student: Person {
    override var dress: String
        get() = "교복"
        set(value) {
        }

    final override fun eat() {
        println("밥을 먹는다")
    }

    fun study() {
        println("공부를 한다 ")
    }

}

class Teacher : Person {
    override var dress: String
        get() = "정장"
        set(value) {}

    override fun eat() {
        println("밥을 먹는다")
    }
}

class GoodStudent: Student() {
    override var dress: String
        get() = "ㅇㅇ"
        set(value) {}
}

val student: Student = Student()
student.eat()
student.sleep()