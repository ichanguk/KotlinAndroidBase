import java.lang.IllegalArgumentException

val numbers = listOf<Int>(1, 2, 3)
try {
    numbers.get(5)
} catch(exception: Exception) {
    println(exception)
}

try {
    numbers.get(5)
} catch (exception: ArrayIndexOutOfBoundsException) {
    println("예외 발생 A")
} catch(exception: IllegalArgumentException) {
    println("예외 발생 B")
} finally {
    println("마지막!")
}