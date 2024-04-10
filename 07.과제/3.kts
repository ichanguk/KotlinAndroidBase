// 3. 학생의 시험 점수를 넣어주면 학점을 반환하는 함수를 만드시오
//   (90점 이상 A학점, 80~89점은 B학점, 70~79점은 C학점, 그렇지 않으면 F학점)

fun calculateGrade(score: Int): Char {
    if (score >= 90) {
        return 'A'
    } else if (score >= 80) {
        return 'B'
    } else if (score >= 70) {
        return 'C'
    } else {
        return 'F'
    }
}

println(calculateGrade(score = 10))
println(calculateGrade(score = 75))
println(calculateGrade(score = 85))
println(calculateGrade(score = 95))
