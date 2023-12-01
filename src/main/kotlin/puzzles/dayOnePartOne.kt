package puzzles

import java.io.File

fun puzzle1(debug:Boolean = false) : Int {
    var sum = 0
    File("src/main/resources/inputs/puzzle1.txt").forEachLine {
        val numbers = mutableListOf(-1, -1)
        for(char in it) {
            if(char.digitToIntOrNull() != null) {
                if(numbers[0] == -1) {
                    numbers[0] = char.digitToInt()
                }
                else {
                    numbers[1] = char.digitToInt()
                }
            }
        }
        sum += if(numbers[1] == -1) {
            11 * numbers[0]
        } else {
            10 * numbers[0] + numbers[1]
        }
        if(debug) {
            println(sum)
            println(it)
            readln()
        }
    }
    return sum
}