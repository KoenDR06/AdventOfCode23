package puzzles

import println
import readInput
import kotlin.reflect.typeOf

fun main() {
//    part1(readInput("day3")).println()
//    part2(readInput("day3")).println()

    part1(listOf(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...$.*....",
        ".664.598.."
    )).println()
}


private fun part1(input: List<String>) : Int {
    val elementList : MutableList<MutableList<String>> = mutableListOf()
    input.forEach { elementList.add(it.split(".").toMutableList())}
    elementList.println()

    val indexList : MutableList< MutableList< Pair< String, Int > > > = mutableListOf()
    for(line in elementList) {
        var index = 0
        for(element in line) {
            if(element != "") {
                indexList.last().add(Pair(element, index))
            }
        }
    }



    var sum = 0
    return sum
}

private fun part2(input: List<String>) {

}
