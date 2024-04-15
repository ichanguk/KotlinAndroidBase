val GOAL_KILL_POINT = 3

open class Warrior constructor(
    hp: Int,
    power: Int,
    defense: Int,
    alive: Boolean = true,
    killPoint: Int = 0
) {
    var hp: Int = 50
        set(value) {
            if (value <= 0) {
                alive = false
            }
            field = value
        }
    var power: Int
    var defense: Int
    var alive: Boolean
    var killPoint: Int

    init {
        this.hp = hp
        this.power = power
        this.defense = defense
        this.alive = alive
        this.killPoint = killPoint
    }

    open fun attack(monster: Monster) {
        println("Warrior가 공격합니다")
        monster.hp -= power - monster.defense
        if (monster.hp <= 0) {
            killPoint++;
            monster.respawn(30)
        }

        monster.printStatus()
        println("현재 kill point는 " + killPoint + "입니다")
    }

    open fun printStatus() {
        if (alive == true) {
            println("Warrior가 살아있습니다. 체력: $hp")
        } else {
            println("Warrior는 죽었습니다.")
        }
    }

    fun levelUp(): Knight {
        return Knight(this)
    }
}

class Knight constructor(warrior: Warrior, energy: Int = 10) :
    Warrior(warrior.hp, warrior.power, warrior.defense, true, warrior.killPoint) {
    var energy: Int

    init {
        this.energy = energy
    }

    fun hardAttack(monster: Monster) {
        if (energy >= 3) {
            energy -= 3
            println("Knight가 강하게 공격합니다. 남은 에너지는 " + energy + "입니다")
            monster.hp -= (power + 10) - monster.defense
            if (monster.hp <= 0) {
                killPoint++;
                monster.respawn(30)
            }
            monster.printStatus()
            println("현재 kill point는 " + killPoint + "입니다")
        } else {
            println("에너지가 부족하여 강하게 공격할 수 없습니다")
            attack(monster)
        }
    }

    override fun printStatus() {
        if (alive == true) {
            println("Knight가 살아있습니다. 체력: $hp")
        } else {
            println("Knight는 죽었습니다.")
        }
    }

    override fun attack(monster: Monster) {
        println("Knight가 공격합니다")
        monster.hp -= power - monster.defense
        if (monster.hp <= 0) {
            killPoint++;
            monster.respawn(30)
        }
        monster.printStatus()
        println("현재 kill point는 " + killPoint + "입니다")
    }
}

class Monster constructor(hp: Int, power: Int, defense: Int, alive: Boolean = true) {
    var hp: Int = 50
    var power: Int
    var defense: Int
    var alive: Boolean

    init {
        this.hp = hp
        this.power = power
        this.defense = defense
        this.alive = alive
        println("Monster 생성")
        printStatus()
    }

    fun respawn(hp: Int) {
        println("Monster가 죽었습니다")
        println("Monster가 리스폰됩니다")
        this.hp = hp
    }

    fun attack(warrior: Warrior) {
        println("Monster 공격합니다")
        warrior.hp -= power - warrior.defense
        warrior.printStatus()
    }

    fun printStatus() {
        if (alive == true) {
            println("Monster 아직 살아있습니다. 체력: $hp")
        } else {
            println("Monster는 죽었습니다.")
        }
    }
}

val warrior = Warrior(50, 20, 10)
val monster = Monster(30, 15, 5)

var i: Int = 0
while(true) {
    if (warrior.alive == false) {
        break
    }
    i++
    println("" + i + "번째 차례")
    warrior.attack(monster)
    if (warrior.killPoint == GOAL_KILL_POINT) {
        println("knight로 레벨업하였습니다")
        println()
        break
    }
    monster.attack(warrior)
    println()
}
if (warrior.alive) {
    val knight = warrior.levelUp()
    while(true) {
        if (knight.alive == false) {
            break
        }
        i++
        println("" + i + "번째 차례")
        knight.hardAttack(monster)
        monster.attack(knight)
        println()
    }
}