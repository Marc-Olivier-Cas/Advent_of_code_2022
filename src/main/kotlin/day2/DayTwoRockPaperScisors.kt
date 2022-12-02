package day2

import java.io.File
import java.util.*

class DayTwoRockPaperScisors {

    fun dayTwoFunctionFirstPart() {
        val input = File("./day_2_input.txt")
        val fileScan = Scanner(input)
        val openentElveMooves = ArrayList<String>()
        val myScriptedMooves = ArrayList<String>()
        while (fileScan.hasNextLine()) {
            val line = fileScan.nextLine()
            val lineSplit = line.split(" ")
            openentElveMooves.add(lineSplit[0])
            myScriptedMooves.add(lineSplit[1])
        }
        println(openentElveMooves)
        println(myScriptedMooves)
        var myScriptedScore = 0
        for (i in openentElveMooves.indices) {
            if (openentElveMooves[i] == "A" && myScriptedMooves[i] == "Y") {
                myScriptedScore += 8 // 6 + 2 points from choosing Paper(Y)
            } else if (openentElveMooves[i] == "A" && myScriptedMooves[i] == "X") {
                myScriptedScore += 4 // 3 + 1 points from choosing Rock(X)
            } else if (openentElveMooves[i] == "A" && myScriptedMooves[i] == "Z") {
                myScriptedScore += 3 // 3 points from choosing Scisors(Z)
            } else if (openentElveMooves[i] == "B" && myScriptedMooves[i] == "Y") {
                myScriptedScore += 5 // 3 + 2 points from choosing Paper(Y)
            } else if (openentElveMooves[i] == "B" && myScriptedMooves[i] == "X") {
                myScriptedScore += 1 // 1 points from choosing Rock(X)
            } else if (openentElveMooves[i] == "B" && myScriptedMooves[i] == "Z") {
                myScriptedScore += 9 // 6 + 3 points from choosing Scisors(Z)
            } else if (openentElveMooves[i] == "C" && myScriptedMooves[i] == "Y") {
                myScriptedScore += 2 // 2 points from choosing Paper(Y)
            } else if (openentElveMooves[i] == "C" && myScriptedMooves[i] == "X") {
                myScriptedScore += 7 // 3 + 4 points from choosing Rock(X)
            } else if (openentElveMooves[i] == "C" && myScriptedMooves[i] == "Z") {
                myScriptedScore += 6 // 6 points from choosing Scisors(Z)
            }
        }
        println("My scripted score is $myScriptedScore")
    }

    fun dayTwoFunctionSecondPart() {
        val input = File("./day_2_input.txt")
        val fileScan = Scanner(input)
        val openentElveMooves = ArrayList<String>()
        val myScriptedMooves = ArrayList<String>()
        while (fileScan.hasNextLine()) {
            val line = fileScan.nextLine()
            val lineSplit = line.split(" ")
            openentElveMooves.add(lineSplit[0])
            myScriptedMooves.add(lineSplit[1])
        }
        println(openentElveMooves)
        println(myScriptedMooves)
        var myScriptedScore = 0
        for (i in myScriptedMooves.indices) {
            when (myScriptedMooves[i]) {
                "X" -> {
                    if (openentElveMooves[i] == "A") {
                        // i have to play Z and loose
                        myScriptedScore += 3
                    } else if (openentElveMooves[i] == "B") {
                        // i have to play X and loose
                        myScriptedScore += 1
                    } else if (openentElveMooves[i] == "C") {
                        // i have to play Y and loose
                        myScriptedScore += 2
                    }
                }
                "Y" -> {
                    if (openentElveMooves[i] == "A") {
                        // i have to play X and draw
                        myScriptedScore += 4
                    } else if (openentElveMooves[i] == "B") {
                        // i have to play Y and draw
                        myScriptedScore += 5
                    } else if (openentElveMooves[i] == "C") {
                        // i have to play Z and draw
                        myScriptedScore += 6
                    }
                }
                "Z" -> {
                    if (openentElveMooves[i] == "A") {
                        // i have to play Y and win
                        myScriptedScore += 8
                    } else if (openentElveMooves[i] == "B") {
                        // i have to play Z and win
                        myScriptedScore += 9
                    } else if (openentElveMooves[i] == "C") {
                        // i have to play X and win
                        myScriptedScore += 7
                    }
                }
            }
            println("My scripted score of the second part is $myScriptedScore")
        }
    }

    fun dayTwoFunctionFirstPartRefactored() {
        File("./day_2_input.txt").readLines()
            .map { it.split(" ") }
            .map { it[0] to it[1] }
            .map { (openentElveMooves, myScriptedMooves) ->
                when (openentElveMooves) {
                    "A" -> when (myScriptedMooves) {
                        "Y" -> 8
                        "X" -> 4
                        "Z" -> 3
                        else -> 0
                    }
                    "B" -> when (myScriptedMooves) {
                        "Y" -> 5
                        "X" -> 1
                        "Z" -> 9
                        else -> 0
                    }
                    "C" -> when (myScriptedMooves) {
                        "Y" -> 2
                        "X" -> 7
                        "Z" -> 6
                        else -> 0
                    }
                    else -> 0
                }
            }
            .sum()
            .let { println("My scripted score is $it hihihihihi") }
    }

    fun dayTwoFunctionSecondPartRefactored() {
        File("./day_2_input.txt").readLines()
            .map { it.split(" ") }
            .map { it[0] to it[1] }
            .map { (openentElveMooves, myScriptedMooves) ->
                when (myScriptedMooves) {
                    "X" -> when (openentElveMooves) {
                        "A" -> 3
                        "B" -> 1
                        "C" -> 2
                        else -> 0
                    }
                    "Y" -> when (openentElveMooves) {
                        "A" -> 4
                        "B" -> 5
                        "C" -> 6
                        else -> 0
                    }
                    "Z" -> when (openentElveMooves) {
                        "A" -> 8
                        "B" -> 9
                        "C" -> 7
                        else -> 0
                    }
                    else -> 0
                }
            }
            .sum()
            .let { println("My scripted score of the second part is $it hahahahahahaha") }
    }

    fun dayTwoFunctionFirstAndSecondPartRefactoredTogether() {
        // First part
        File("./day_2_input.txt").readLines()
            .map { it.split(" ") }
            .map { it[0] to it[1] }
            .map { (openentElveMooves, myScriptedMooves) ->
                when (openentElveMooves) {
                    "A" -> when (myScriptedMooves) {
                        "Y" -> 8
                        "X" -> 4
                        "Z" -> 3
                        else -> 0
                    }
                    "B" -> when (myScriptedMooves) {
                        "Y" -> 5
                        "X" -> 1
                        "Z" -> 9
                        else -> 0
                    }
                    "C" -> when (myScriptedMooves) {
                        "Y" -> 2
                        "X" -> 7
                        "Z" -> 6
                        else -> 0
                    }
                    else -> when (myScriptedMooves) {
                        "X" -> 3
                        "Y" -> 4
                        "Z" -> 8
                        else -> 0
                    }
                }
            }
            .sum()
            .let { println("My scripted score is $it hohohohoho") }
        // Second part
        File("./day_2_input.txt").readLines()
            .map { it.split(" ") }
            .map { it[0] to it[1] }
            .map { (openentElveMooves, myScriptedMooves) ->
                when (myScriptedMooves) {
                    "X" -> when (openentElveMooves) {
                        "A" -> 3
                        "B" -> 1
                        "C" -> 2
                        else -> 0
                    }
                    "Y" -> when (openentElveMooves) {
                        "A" -> 4
                        "B" -> 5
                        "C" -> 6
                        else -> 0
                    }
                    "Z" -> when (openentElveMooves) {
                        "A" -> 8
                        "B" -> 9
                        "C" -> 7
                        else -> 0
                    }
                    else -> 0
                }
            }
            .sum()
            .let { println("My scripted score of the second part is $it huhuhuhuhuhu") }
    }
}
