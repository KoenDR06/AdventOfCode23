package puzzles

import println
import readInput
import kotlin.math.abs

fun main() {
    part1(readInput("day6")).println()
    part2(readInput("day6")).println()

    part2(listOf(
        "7 15 30",
        "9 40 200"
    )).println()
}


private fun part1(input: List<String>) : Int {
    val maxTime = input[0].split(" ")
    val minThreshold = input[1].split(" ")
    var sum = 1

    for(i in maxTime.indices) {
        for(x in 0..maxTime[i].toInt()) {
            if(x * (maxTime[i].toInt() - x) > minThreshold[i].toInt()) {
                sum *= (abs(x - (maxTime[i].toInt() - x)) + 1)
                break
            }
        }
    }
    return sum
}

private fun part2(input: List<String>) : Long {
    val maxTime = input[0].replace(" ", "").toLong()
    maxTime.println()
    val minThreshold = input[1].replace(" ", "").toLong()
    minThreshold.println()
    var sum = 0L

    for(x in 0..maxTime) {
        430121812131276.println()
        (x * (maxTime - x)).println()
        "".println()
        if(x * (maxTime - x) > minThreshold) {
            sum = (abs(x - (maxTime - x)) + 1)
            break
        }
        readln()
    }
    return sum
}