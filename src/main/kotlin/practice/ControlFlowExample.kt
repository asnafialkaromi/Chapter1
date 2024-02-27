package practice

import app.model.ComputerSpec

class ControlFlowExample {

    private val computerData = listOf(
        ComputerSpec (
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = true,
            totalRamInGb = 32,
            EGPUName = "RTX 4060"
        ),
        ComputerSpec (
            processorName = "Intel i7",
            processorTotalCore = 8,
            isHaveIGPU = false,
            totalRamInGb = 16,
            EGPUName = "RTX 4050"
        )
    )

    fun run () {
//        println(checkName("Asnafi"))
//        println(checkNameUsingWhen("Asnafi"))
//        println(exampleWhen())
//        println(checkName())
        println(printSomething())
    }

    private fun checkName (name: String?) : String{
        return if (name == null){
            "Your name still empty"
        } else if (name.contains("Asnafi", ignoreCase = true)){
            "Asnafi adalah seorang developer"
        } else if (name.contains("Ahmad", ignoreCase = true)){
            "Ahmad adalah seorang UI/UX"
        } else {
            "Tidak tahu pekerjaannya"
        }
    }

    private fun checkNameUsingWhen (name: String?) : String {
        //when biasanya digunakan untuk nilai yang fix
        return when (name){
            "agus" -> "Apakah kamu lahir dibulan Agustus?"
            "raya" -> "Apakah kamu lahir di hari raya?"
            else -> {
                "Data kamu tidak ada"
            }
        }
    }

    private fun exampleWhen(){
        val contentType = ContentType.REELS
        when (contentType) {
            ContentType.PHOTO -> {
                println("konten foto")
            }
            ContentType.VIDEO -> {
                println("konten video")
            }
            ContentType.REELS -> {
                println("konten reels")
            }
        }
    }

    private var name : String? = "Tony Stark"

    private fun checkName (){
        //escape condition
        if (name == null ) return
        println("Nama anda adalah $name")
        println("Anda adalah anak pemilik BCA")
    }

    private fun printSomething() {
        for (index in 0..3){
            println("Ini looping ke : $index")
        }
        //step looping
        for (index in 0..10 step 2){
            println("Ini looping ke : $index")
        }
        //downto looping
        for (index in 10 downTo 1 step 2){
            println("Ini looping ke : $index")
        }
        //for-loop manual
        for (index in computerData.indices){
            println("$index ${computerData[index]}")
        }

        //equivalent
        computerData.forEach{
            println("$it")
        }

        //with indexed
        computerData.forEachIndexed { index, computerSpec ->
            println("${index + 1} $computerSpec")
        }

        //dowhile
        var index = 0
        do {
            println(index)
            index++
        } while (index < 5)

        index = 0
        while (index < 5){
            println(index)
            index++
        }

        //escape
        for (index in 0..10){
            if (index == 5) continue
            println("Ini looping ke : $index")
        }

        //destroy the loop
        for (index in 0..10){
            if (index == 5) break
            println("Ini looping ke : $index")
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ControlFlowExample().run()
        }
    }
}

enum class ContentType {
    PHOTO,VIDEO,REELS
}