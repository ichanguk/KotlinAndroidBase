// 5. 시험 성적 리스트 [70,71,72,77,78,79,80,82,90,99]
//   와 동일한 크기의 배열을 만들고, 합격이면 true, 불합격이면 false를 담는 함수를 만드시오
//   (80점 이상 부터 합격, 정답 예시 (False,False,...))

fun checkPassOrFail(scores: List<Int>): Array<Boolean> {
    var result = Array<Boolean>(scores.size, { false })
    for ((index, score) in scores.withIndex()) {
        if (score >= 80) {
            result.set(index, true)
        }
    }
    return result
}

val scores = listOf(70, 71, 72, 77, 78, 79, 80, 82, 90, 99)
checkPassOrFail(scores).forEach {
    println(it)
}


