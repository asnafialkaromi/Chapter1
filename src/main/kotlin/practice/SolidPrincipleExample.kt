package practice

class CalculatorWrong() {
    fun plus(a: Int, b: Int) {
        val result = a + b
        println("Result is : $result")
    }
}

class CalculatorRight() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }
}

fun printResult(result: Number) {
    println("The Result is $result")
}

class RockPaperScissorOld() {
    fun suit() {
        println(
            """
            ======================================
            GUNTING BATU KERTAS
            ======================================
            OPTION
            0. Gunting
            1. Batu
            2. Kertas
        """.trimIndent()
        )
        println("Masukkan pilihan 1 (0/1/2):")
        val playerOne = readln().toInt()
        println("Masukkan pilihan 2 (0/1/2):")
        val playerTwo = readln().toInt()
        if (((playerOne + 1) % 3) == playerTwo) {
            println("Player 2 menang")
        } else if (playerOne == playerTwo) {
            println("Seri")
        } else (
                println("Player 1 menang")
                )
    }
}

class RockPaperScissorNew() {
    private var playerOne: Int = -1
    private var playerTwo: Int = -1

    private fun printOption() {
        println(
            """
            ======================================
            GUNTING BATU KERTAS
            ======================================
            OPTION
            0. Gunting
            1. Batu
            2. Kertas
        """.trimIndent()
        )
    }

    private fun inputPlayerOne() {
        println("Masukkan pilihan 2 (0/1/2):")
        playerOne = readln().toInt()
    }

    private fun inputPlayerTwo() {
        println("Masukkan pilihan 2 (0/1/2):")
        playerTwo = readln().toInt()
    }

    private fun showResult(playerOne: Int, playerTwo: Int): String {
        return if (((playerOne + 1) % 3) == playerTwo) {
            "Player 2 menang"
        } else if (playerOne == playerTwo) {
            "Seri"
        } else {
            "Player 1 menang"
        }
    }

    fun run() {
        printOption()
        inputPlayerOne()
        inputPlayerTwo()
        println(showResult(playerOne, playerTwo))
    }
}

// Open - Closed

open class IronManSuit() {
    open fun blast() {
        println("Blast using laser powered by Arc Reactor")
    }

    fun activeAi() {
        println("Jarvis is active")
    }

}

class WarMachineSuit() : IronManSuit() {
    override fun blast() {
        //super.blast()
        println("Blass form war machine suit")
    }
}

// Liskov Substitution
// using hot air balloon
class Capadocia() {
    private lateinit var balloon: HotAirBalloon

    fun run() {
        balloon = BlueHotAirBalloon()
        balloon.apply {
            carryPassengers()
            blow()
            pop()
        }
    }
}

fun main(args: Array<String>) {
//    RockPaperScissorNew().run()
    Capadocia().run()
}

// Interface Segregation
interface Animal {
    fun eat()
    fun hunt()
    fun walking()

    fun jump()
    fun breath()
    fun sound()
    fun reproduction()
}

interface Aves : Animal {
    fun fly()
    fun twit()
}

interface Fish : Animal {
    fun swim()
}

class Bird() : Aves {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }

    override fun twit() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }

}

class CatFish() : Fish {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }

}

// Dependency Inversion

class FirebaseAnalytics() {
    fun log(event: String) {
        println("Logging to firebase : Event Name : $event")
        Thread.sleep(2000)
        println("Logging Success")
    }
}

class NewRelicAnalytics() {
    fun log(event: String) {
        println("Logging to newrelic : Event Name : $event")
        Thread.sleep(2000)
        println("Logging Success")
    }
}

class MoEngangeAnalytics() {
    fun log(event: String) {
        println("Logging to moengange : Event Name : $event")
        Thread.sleep(2000)
        println("Logging Success")
    }
}

interface Analytics {
    fun logEvent(event: String)
}

//agnostik analytics
class AppAnalytics() : Analytics {
    private var firebaseAnalytics = FirebaseAnalytics()
    private var moEngangeAnalytics = MoEngangeAnalytics()
    private var newRelicAnalytics = NewRelicAnalytics()

    override fun logEvent(event: String) {
        firebaseAnalytics.log(event)
        moEngangeAnalytics.log(event)
        newRelicAnalytics.log(event)
    }
}

class SplashScreen(private val analytics: Analytics) {
    fun openPage() {
        println("Open page splashscreen")
        analytics.logEvent("SplashScreen")
    }
}

class HomeScreen(private val analytics: Analytics) {
    fun openPage() {
        println("Open page home")
        analytics.logEvent("Home")
    }
}

class LoginScreen(private val analytics: Analytics) {
    fun openPage() {
        println("Open page loginscreen")
        analytics.logEvent("Login")
    }
}

class App {

    private val analytics = AppAnalytics()

    fun run() {
        SplashScreen(analytics).openPage()
        HomeScreen(analytics).openPage()
        LoginScreen(analytics).openPage()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}