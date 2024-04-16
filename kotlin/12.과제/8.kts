// 8. 병사 그룹 2개와 n번째 값을 넣어주면, 각각의 병사 그룹에서 n번째 병사를 제거하고, 두개의 병사
//   그룹을 합쳐주는 함수를 만드시오
//   fun abc( ["A", "B", "C", ,"D", "E"] ,  ["A", "B", "C"], 2)
//   -> [["A", "B", "D", "E"], ["A", "B"]]
//
//   (합수 실행이 어려운 조건을 만나면 null을 리턴해야한다)
//   fun abc( ["A", "B", "C", ,"D", "E"] ,  ["A", "B", "C"], 100)
//   -> null

fun mergeArmyExceptN(A: List<String>, B: List<String>, n: Int): MutableList<MutableList<String>>? {
    var ACopy: MutableList<String> = mutableListOf()
    var BCopy: MutableList<String> = mutableListOf()
    ACopy.addAll(A)
    BCopy.addAll(B)

    var result: MutableList<MutableList<String>>? = mutableListOf<MutableList<String>>()
    if (ACopy.size <= n || BCopy.size <= n) {
        return null
    } else {
        ACopy.removeAt(n)
        BCopy.removeAt(n)
        result!!.add(ACopy)
        result!!.add(BCopy)
    }
    return result
}

println(mergeArmyExceptN(listOf("A", "B", "C", "D", "E"), listOf("A", "B", "C"), 2))
println(mergeArmyExceptN(listOf("A", "B", "C", "D", "E"), listOf("A", "B", "C"), 100))