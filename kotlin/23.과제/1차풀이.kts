val GOAL_KILL_POINT: Int = 5

open class Character constructor(
    name: String,
    hp: Int,
    power: Int,
    defense: Int,
    live: Boolean = true
) {
    var name: String
    var hp: Int = 50
    var power: Int
    var defense: Int
    var live: Boolean

    init {
        this.name = name
        this.hp = hp
        this.power = power
        this.defense = defense
        this.live = live
    }

    fun isAlive(): Boolean {
        return live
    }

    open fun attack(target: Character) {
        println(name + "가 공격합니다")
        target.hp -= power - target.defense
        if (target.hp <= 0) {
            target.live = false
        }
        target.printStatus()
    }

    fun printStatus() {
        if (live) {
            println(name + " 아직 살아 있습니다. 체력: " + hp)
        } else {
            println(name + "는 죽었습니다")
        }
    }
}

open class Warrior(
    name: String,
    hp: Int,
    power: Int,
    defense: Int,
    killCount: Int = 0,
) : Character(name, hp, power, defense) {
    var killCount: Int

    init {
        this.killCount = killCount
    }

    fun plusKill() {
        killCount++
        println("현재 kill count는 " + killCount + "입니다.")
        if (killCount == GOAL_KILL_POINT) {
            name = "Knight"
            println("목표 처치 수를 달성하여 Kngiht로 레벨업합니다")
        }
    }
}

class Knight(
    warrior: Warrior,
    var energy: Int = 100,
    killCount: Int = 0
) : Warrior(warrior.name, warrior.hp, warrior.power, warrior.defense, killCount) {

    fun hardAttack(target: Character) {
        if (name == "Knight") {
            if (energy >= 3) {
                energy -= 3
                println(name + "이 강하게 공격합니다. 남은 에너지는 " + energy + "입니다.")
                target.hp -= (power + 10) - target.defense
                if (target.hp <= 0) {
                    target.live = false
                }
                target.printStatus()
            } else {
                println("에너지가 부족합니다")
            }
        } else {
            attack(target)
        }

    }
}

open class Monster constructor(
    name: String,
    hp: Int,
    power: Int,
    defense: Int,
    live: Boolean = true
) : Character(name, hp, power, defense, live) {
    init {
        println(name + " 생성")
        printStatus()
    }

    override fun attack(target: Character) {
        println(name + " 공격합니다")
        target.hp -= power - target.defense
        if (target.hp <= 0) {
            target.live = false
        }
        target.printStatus()
    }

    fun respawn() {
        hp = 40
        live = true
    }
}


val monster = Monster("Monster", 40, 20, 5)
val warrior = Warrior("Warrior", 100, 25, 10, 0)
val knight = Knight(warrior)


for (i in 1..12) {
    println("" + i + "번째 싸움 시작")
    knight.hardAttack(monster)
    if (monster.isAlive() == false) {
        knight.plusKill()
        monster.respawn()
        println("Monster가 리스폰됩니다")
    }
    monster.attack(knight)

    println("" + i + "번째 싸움 끝\n")
}
