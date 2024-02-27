package practice

import app.model.ComputerSpec

class ScopeFunctionExample {

    private val creatorName : String? = null
    private var computerData : ComputerSpec? = null

    fun run () {
        // let
        creatorName?.let {
            println("Created by : $creatorName")
        } ?: run{
            println("This Program is open Source")
        }

        /* Equals
        *  if (creatorName == null) {
            println("Created by : $creatorName")
            } else {
            println("This Program is open Source")
            }
        * */

        // Apply
        println(computerData)
        computerData?.apply {
            this.processorName = "Intel Pentium"
        } ?: run { println("Computer data is null")}
        computerData = ComputerSpec (
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = true,
            totalRamInGb = 32,
            EGPUName = "RTX 4060"
        )
        computerData?.apply {
            this.processorName = "Intel Pentium"
        } ?: run { println("Computer data is null")}
        println(computerData)

        // with
        //before
        println(computerData?.processorName)
        println(computerData?.totalRamInGb)
        println(computerData?.isHaveIGPU)

        //after
        with(computerData){
            println(this?.processorName)
            println(this?.totalRamInGb)
            println(this?.isHaveIGPU)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ScopeFunctionExample().run()
        }
    }
}