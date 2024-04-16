val numbers = intArrayOf(5, 10, 15)

for (number in numbers) {
    println(number)
}

// 값과 인덱스 모두 필요할 때
for ((index, value) in numbers.withIndex()) {
    println(index)
    println(value)
}

println("-----------")
// 인덱스만 필요할 때
for (index in numbers.indices) {
    println(index)
}

println("--------")
numbers.forEachIndexed { index, value ->
    println("" + index + value)
}
