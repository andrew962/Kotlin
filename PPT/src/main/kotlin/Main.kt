import kotlin.random.Random

fun main() {
    intro()
    game()
}

fun game() {
    /**
     * 1 - Piedra
     * 2 - Papel
     * 3 - Tijeras
     */

    println("Elige una opción (número).")
    println("1 - Piedra")
    println("2 - Papel")
    println("3 - Tijeras")
    println("Opcion: ")
    val opc = readln()
    val opcList: List<String> = listOf("Piedra", "Papel", "Tijeras")
    val randomNum = Random.nextInt(1, 3)
    val opcInt = opc.toInt()
    println("El humano eligio ${opcList[opcInt - 1]}, la maquina eligio ${opcList[randomNum - 1]}")
    if (opcInt == randomNum) {
        println("Es un empate.")
    } else {
        if (opcInt == 1 || randomNum == 1) {
            if (opcInt == 1 && randomNum != 3) {
                println("Gano la maquina.")
            } else if (randomNum == 1 && opcInt != 3) {
                println("Gano el humano.")
            }
        }
        if (opcInt == 2 || randomNum == 2) {
            if (opcInt == 2 && randomNum != 1) {
                println("Gano la maquina.")
            } else if (randomNum == 2 && opcInt != 1) {
                println("Gano el humano.")
            }
        }
        if (opcInt == 3 || randomNum == 3) {
            if (opcInt == 3 && randomNum != 2) {
                println("Gano la maquina.")
            } else if (randomNum == 3 && opcInt != 2) {
                println("Gano el humano.")
            }
        }
    }

}

fun intro() {
    println("Jugaremos a piedra, papel o tijeras.")
}