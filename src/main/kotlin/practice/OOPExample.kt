package practice
// Encapsulation
private class AClass() {
    private fun run() {
        println("This is from class A")
    }

    fun runPublic() {
        println("This is from class A in public")
    }
}

class BClass () {
    fun run (){
        // we cannot call run because it's private
        // AClass().run()
        AClass().runPublic()
        println("This is from class B")
    }
}

// Abstraction
interface Balloon {
    fun blow()
    fun pop()
}

abstract class HotAirBalloon : Balloon {
    override fun blow() {
        println("Blow the balloon using hot air")
    }

    override fun pop() {
        println("Danger!!!")
    }

    fun moveLeft(){
        println("Move the balloon to the left")
    }

    // wajib untuk di implemen di turunan class nya
    abstract fun carryPassengers()
}

class RedHotAirBalloon : HotAirBalloon () {
    // wajin untuk di implemen di turunan class nya
    override fun carryPassengers() {
        println("Carrying 5 Passengers")
    }

    override fun blow() {
        println("blowing balloon using Do'a")
    }

    // overloading
    fun blow(name: String){

    }
}

class BlueHotAirBalloon : HotAirBalloon () {
    // wajin untuk di implemen di turunan class nya
    override fun carryPassengers() {
        println("Carrying 5 Passengers")
    }

    override fun blow() {
        println("blowing balloon using Blue Energy")
    }

    // overloading
    fun blow(name: String){

    }
}

// polymorphism
class RedBalloon() : Balloon {
    override fun blow() {
        println("Meniup balon merah...")
    }

    override fun pop() {
        println("Balon merah meledak!!!")
    }
}

class BlueBalloon() : Balloon {
    override fun blow() {
        println("Meniup balon biru...")
    }

    override fun pop() {
        println("Balon biru meledak!!!")
    }
}

// inheritance using open class
open class Processor (private val name: String) {
    open fun initProcessor () {
        println("Initialize.... $name")
    }
}

class AMDProcessor() : Processor ("Ryzen 9")
class IntelProcessor() : Processor ("i3")

fun main(args: Array<String>) {
    RedHotAirBalloon().let {
        // sifat kakek
        it.blow()
        it.pop()

        // sifat bapak
        it.moveLeft()
        it.carryPassengers()
    }
    AMDProcessor().initProcessor()
    IntelProcessor().initProcessor()
}