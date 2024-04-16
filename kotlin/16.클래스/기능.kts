class FootballPlayer constructor(uniform: String, ball: String) {
    val uniform: String
    val ball: String
    init {
        this.uniform = uniform
        this.ball = ball
    }

    fun kick() {
        if (ball == "축구공") {
            println("공을 찼다")
        } else {
            println("공이 없다.")
        }
    }
    fun pass() {
        println("패스!")
    }
}

val footballPlayer = FootballPlayer("빨간색 유니폼", "축구공")
println(footballPlayer.uniform)
footballPlayer.kick()
footballPlayer.pass()