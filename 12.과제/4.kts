// 4. 100 보다 작은 숫자를 넣어주면, 1씩 증가를 시키고 100 이 되면 종료되는 함수를 만드시오

fun printTo100(n: Int): Unit {
    var num = n
    while (num < 100) { // num <= 100을 사용하게 되면 num이 최종적으로 101이 됨
        println(num)
        num++
    }
}

printTo100(78)