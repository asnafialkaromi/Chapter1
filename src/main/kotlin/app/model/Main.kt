package app.model

// Define with data types
val index : Int = 0 // Immutabel > Tidak bisa kita ubah nilainya
var aString : String = "11/100" // Mutable > bisa kita ubah nilainya

// Define without data types
val anotherSring = "Lorem ipsum"
val anNumber = 19
val anNumber2 = 19.2
val anNumber3 = 19.2129873621987126389127362
val anNumber4 = 191283721321

// Konstanta
const val anNumber5 = 19.12378612398127368912

// Array
val arrayData : Array<String> = arrayOf("1","2","3")
val arrData = arrayOf("1","2","3")

// List -> Tidak bisa memanipulasi data
val listData : List<String> = listOf("1","2","3")
val listData2 = listOf("1","2","3")

// Mutable List -> Bisa memanipulasi data
val mutableList = mutableListOf<String>("12","13","14")

fun main(args: Array<String>) {
//    try {
//        println(mutableList) // 12,13,14,15
//        mutableList.add("15")
//        println(mutableList) // 12,13,14,15
//        mutableList.removeAt(index = 0)
//        println(mutableList) // 13,14,15
//        mutableList.remove(element = "13")
//        println(mutableList) // 14,15
//    }catch (e: Exception) {
//        println("Code Error")
//    }
}

