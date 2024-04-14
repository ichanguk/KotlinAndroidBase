// getter / setter
class Book() {
    var title: String = "모름"
        get() {
            return field
        }
        set(value) {
            field = value
            //title = value //이렇게 쓰는 게 아님 field 사용
        }
}
//
//val book = Book()
//println(book.title)
//book.title = "제목 변경"
//println(book.title)

// lateinit
class Book2() {
    lateinit var title:String

    fun nextPage() {
        if (::title.isInitialized == true) {
            println("페이지가 넘어간다")
        } else {
            println("초기화 필요")
        }
    }
}

val book = Book2()
//println(book.title) // 초기화 되지 않아서 오류남
book.nextPage() // 초기화 필요 출력

book.title = "허클베리 핀의 모험"
book.nextPage() // 페이지가 넘어간다 출력

// Lazy
// - 호출시점에 by lazy 정의에 의해 초기화 수행
// - val에서만 사용이 가능하다
class Book3 {
    val title: String by lazy {
        // 본문 -> 다른 작업도 할 수 있지만 반드시 프로퍼티를 초기화 시켜주는 작업을 해야 한다
        println("lazy 초기화")
//        title = "책 제목" // 불가능
//        return "책 제목" // 불가능
        "책 제목"// 이렇게 하면 title이 "책 제목"으로 초기화됨
    }
}

val book3 = Book3()
println(book3.title)

