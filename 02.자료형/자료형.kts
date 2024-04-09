// 변수를 자료형과 함께 선언하는 방법
// -> val/var 변수명 : 타입 = 값
val byteInt: Byte = 10
val shortInt: Short = 10
val integerInt: Int = 10
val longInt: Long = 10

//val wrongByte: Byte = 10000 // 에러남, Byte가 표현할 수 있는 수범위 보다 큰 수를 넣음
//val wrongByte: Byte = "안녕하세요" // 에러남, 타입 미스매치

//val floatNumber: Float = 10.0 // 에러남, f를 넣어야함
val floatNumber: Float = 10.0f
val doubleNumber: Double = 10.0 // Double은 안붙여도 됨, 10.0이 아니라 10은 안됨

// 타입 추론
val number1 = 10 // Int
val number2 = 10.0 // Double

// 논리형
val yes: Boolean = true
val no: Boolean = false

// 문자형
val text1: Char = 'A'
//val text2: Char = 'AA' // Char형은 문자가 반드시 하나만 들어가야 함
//val text3: Char = "A" // 타입 미스매치 에러 발생

// 문자열형
val text4: String = "안녕하세요"
val text5: String = "A"
