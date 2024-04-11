// Range
val range1 = 1..10
println(range1) // "1..10"이 출력됨
//for (x in range1){
//    println(x)
//}

val range2 = 1 until 10
println(range2)
val range3 = 'A'..'Z'
println(range3)

// Progression
val range4 = 1..10 step 2
println(range4)

val range5 = 10 downTo 1 step 2
println(range5)

// collection
val collection1 = listOf<Int>(1, 2, 3, 4, 5)
