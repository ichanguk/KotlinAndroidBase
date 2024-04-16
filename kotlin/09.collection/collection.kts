//List
val numbers = listOf<Int>(1, 2, 3)
val numbers2 = mutableListOf<Int>(1,2,3)
numbers2.add(50)
println(numbers2)
numbers2.removeAt(0)
println(numbers2)
numbers2.addAll(2, listOf<Int>(100, 100)) //2번째 index에 list 추가
println(numbers2)


//Set
val numbers3 = setOf<Int>(1, 1, 1, 3, 3, 4)
println(numbers3.contains(5))
println(numbers3.containsAll(setOf<Int>(1, 3)))

val numbers4 = mutableSetOf<Int>(1, 1, 1, 3, 3, 4)

println(numbers3) // [1, 3, 4]

//Map
val numbers5 = mapOf<Int, String>(1 to "one", 2 to "two")
val numbers6 = mapOf<Int, String>(Pair(1, "one"), Pair(2, "two"))

println(numbers5.keys)
println(numbers5.values)
println(numbers5[1])
println(numbers5.getOrDefault(1, "default"))