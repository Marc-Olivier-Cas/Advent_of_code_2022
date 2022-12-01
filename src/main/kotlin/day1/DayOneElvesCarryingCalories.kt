package day1

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class DayOneElvesCarryingCalories {
    fun dayOneFunction() {
        val caloriesInput = ArrayList<String>()
        val elvesCarrierRanking = ArrayList<Int>()
        val input = File("./day_1_input.txt")
        val fileScan = Scanner(input)
        while (fileScan.hasNextLine()) {
            caloriesInput.add(fileScan.nextLine())
        }
        var dynamicCount = 0
        for (lineValue in caloriesInput.indices) {
            if (caloriesInput[lineValue] != "") {
                dynamicCount += caloriesInput[lineValue].toInt()
            } else {
                elvesCarrierRanking.add(dynamicCount)
                dynamicCount = 0
            }
        }
        var small: Int
        for (i in 0 until elvesCarrierRanking.size - 1) {
            small = i
            for (j in elvesCarrierRanking.indices) {
                if (elvesCarrierRanking[j] < elvesCarrierRanking[small]) {
                    small = j
                    val temp = elvesCarrierRanking[i]
                    elvesCarrierRanking[i] = elvesCarrierRanking[small]
                    elvesCarrierRanking[small] = temp
                }
            }
        }
        val biggestCaloriesCarrier = elvesCarrierRanking.maxOrNull()
        val threeBiggestCaloriesCarrier = elvesCarrierRanking[0] + elvesCarrierRanking[1] + elvesCarrierRanking[2]
        println("Among all elves, the highest dynamicCount of calories is $biggestCaloriesCarrier")
        println("Among all elves, the top 3 elves is carrying $threeBiggestCaloriesCarrier calories")
    }

    fun optimisedDayOneFunction() {
        val caloriesInput = ArrayList<String>()
        val elvesCarrierRanking = ArrayList<Int>()
        val input = File("./day_1_input.txt")
        val fileScan = Scanner(input)
        while (fileScan.hasNextLine()) {
            caloriesInput.add(fileScan.nextLine())
        }
        var dynamicCount = 0
        for (lineValue in caloriesInput.indices) {
            if (caloriesInput[lineValue] != "") {
                dynamicCount += caloriesInput[lineValue].toInt()
            } else {
                elvesCarrierRanking.add(dynamicCount)
                dynamicCount = 0
            }
        }
        val biggestCaloriesCarrier = elvesCarrierRanking.maxOrNull()
        val threeBiggestCaloriesCarrier = elvesCarrierRanking.sorted().takeLast(3).sum()
        println("Among all elves, the highest dynamicCount of calories is $biggestCaloriesCarrier")
        println("Among all elves, the top 3 elves is carrying $threeBiggestCaloriesCarrier calories")
    }

    fun optimisedDayOneFunctionWithoutWhile() {
        ArrayList<String>()
            .apply {
                File("./day_1_input.txt")
                    .forEachLine { add(it) }
            }
            .let { caloriesInput ->
                ArrayList<Int>()
                    .apply {
                        var dynamicCount = 0
                        for (lineValue in caloriesInput.indices) {
                            if (caloriesInput[lineValue] != "") {
                                dynamicCount += caloriesInput[lineValue].toInt()
                            } else {
                                add(dynamicCount)
                                dynamicCount = 0
                            }
                        }
                    }
                    .let { elvesCarrierRanking ->
                        val biggestCaloriesCarrier = elvesCarrierRanking.maxOrNull()
                        val threeBiggestCaloriesCarrier = elvesCarrierRanking.sorted().takeLast(3).sum()
                        println("Among all elves, the highest dynamicCount of calories is $biggestCaloriesCarrier")
                        println("Among all elves, the top 3 elves is carrying $threeBiggestCaloriesCarrier calories")
                    }
            }
    }
}
