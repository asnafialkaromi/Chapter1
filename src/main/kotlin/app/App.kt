package app

import app.model.ComputerSpec

class App (var creatorName: String? = null){ // Default value contructor

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
        ),ComputerSpec (
            processorName = "Intel i3",
            processorTotalCore = 6,
            isHaveIGPU = false,
            totalRamInGb = 16,
            EGPUName = "RTX 2080"
        )
    )

    fun run () {
        printHeader()
        getSelectedComputer()
    }

    private fun printHeader() {
        println("================================")
        println("Created bt : $creatorName")
        println("================================")
        println("Order PC App")
        println("================================")
        computerData.forEachIndexed{index,data ->
            println("${index + 1}.${data.processorName} : ${data.EGPUName}")
        } // lamda function
        println("================================")
    }

    /*private var selectedComputer : ComputerSpec? = null*/

    private fun getSelectedComputer(){
        println("Masukkan pilihan anda :")
        try {
            val selectedIndex = readln().toInt()
            if (selectedIndex in 1..computerData.size){
                val selectedComputer  = computerData[selectedIndex -1 ].processorName
                println("Pilihan komputer anda : $selectedComputer")
            } else {
                println("Pilihan anda salah, Silahkan coba lagi")
                getSelectedComputer()
            }
        } catch (e : NumberFormatException) {
            println("Menu Anda Salah")
            printHeader() //Recursive
            getSelectedComputer()
        }
    }

    companion object {
        @JvmStatic //annotation
        fun main(args: Array<String>) {
            App("Asnafi").run()
        }
    }
}
