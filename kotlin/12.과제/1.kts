// 1. 주어진 문자를 N번 반복해서 출력하는 함수를 만들어 보자

fun repeatPrintChar(c: Char, N: Int): Unit {
    for (i in 0 until N) {
        println(c)
    }
}

repeatPrintChar('*', 5)