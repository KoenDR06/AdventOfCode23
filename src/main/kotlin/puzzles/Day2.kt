package puzzles

import println
import readInput

fun main() {
    Day2().part1(readInput("day2")).println()
    Day2().part2(readInput("day2")).println()

    Day2().part2(listOf(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
    )).println()
}

class Day2 {
    fun part1(input: List<String>): Int {
        var sum = 0

        val redMax = 12
        val greenMax = 13
        val blueMax = 14

        for((index, line) in input.withIndex()) {
            val roundData = line.split(": ")[1].split("; ")
            val cubeData = mutableListOf<String>()

            roundData.forEach {
                cubeData += it.split(", ")
            }

            var valid = true
            cubeData.forEach {cube ->
                val arr = cube.split(" ")
                if(arr[1] == "red" && arr[0].toInt() > redMax) {
                    valid = false
                }else if(arr[1] == "green" && arr[0].toInt() > greenMax) {
                    valid = false
                }else if(arr[1] == "blue" && arr[0].toInt() > blueMax) {
                    valid = false
                }
            }
            if(valid) {
                sum += index + 1
            }
        }


        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0

        for(line in input) {
            val roundData = line.split(": ")[1].split("; ")
            val cubeData = mutableListOf<String>()

            roundData.forEach {
                cubeData += it.split(", ")
            }

            var redMin = 0
            var greenMin = 0
            var blueMin = 0
            cubeData.forEach {cube ->

                val arr = cube.split(" ")
                if(arr[1] == "red") {
                    if(arr[0].toInt() > redMin) {
                        redMin = arr[0].toInt()
                    }
                }else if(arr[1] == "green") {
                    if(arr[0].toInt() > greenMin) {
                        greenMin = arr[0].toInt()
                    }
                }else if(arr[1] == "blue") {
                    if(arr[0].toInt() > blueMin) {
                        blueMin = arr[0].toInt()
                    }
                }

            }
            sum += redMin * greenMin * blueMin
        }


        return sum
    }
}