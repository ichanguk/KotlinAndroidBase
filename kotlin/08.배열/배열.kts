// 배열을 선언하는 방법(1)
var array1 = arrayOf(true, "HI", 10, 2.2)
//for (x in array1) {
//    println(x)
//}

//<Int?>하면 null도 요소로 넣을 수 있음
var array2 = arrayOf<Int>(1, 2, 3, 4, 5)

var array3 = intArrayOf(1, 2, 3, 4, 5)

var array4 = Array(10, { 0 })

var array5 = IntArray(10, {0})

println(array4[2])

var array6 = Array<Int>(10, {0})
var array7 = Array<String>(10, {""})
var array8 = arrayOf<Int>(10, 20, 30, 40)
println(array8[2])
println(array8.get(2))

array8[0] = 100
println(array8[0])

array8.set(0, 200)
println(array8[0])

val examScore1: Int = 100
val examScore2: Int = 90
val examScore3: Int = 80
val examScores = arrayOf<Int>(examScore1, examScore2, examScore3)

val examScore4 = examScores[0]
println(examScore4)