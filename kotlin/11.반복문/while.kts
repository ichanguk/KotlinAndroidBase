// while문 실습

var i = 0
// 무한루프 발생하는 코드(조건을 종료시킬만한 변화를 줘야됨)
//while (i < 5) {
//    if (i % 2 == 0) {
//        println("짝수")
//    } else {
//        println("홀수")
//    }
//}

while (i < 5) {
    if (i % 2 == 0) {
        println("짝수")
    } else {
        println("홀수")
    }
    i++
}

var z = 10
do {
    println("시작" + z)
    z++
} while(z < 20)