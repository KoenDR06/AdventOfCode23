package puzzles

import println
import readInput

fun main() {
//    part1(readInput("day5")).println()
//    part2(readInput("day5")).println()

    part1(listOf(
        "seeds: 79 14 55 13",
        "",
        "seed-to-soil map:",
        "50 98 2",
        "52 50 48",
        "",
        "soil-to-fertilizer map:",
        "0 15 37",
        "37 52 2",
        "39 0 15",
        "",
        "fertilizer-to-water map:",
        "49 53 8",
        "0 11 42",
        "42 0 7",
        "57 7 4",
        "",
        "water-to-light map:",
        "88 18 7",
        "18 25 70",
        "",
        "light-to-temperature map:",
        "45 77 23",
        "81 45 19",
        "68 64 13",
        "",
        "temperature-to-humidity map:",
        "0 69 1",
        "1 0 69",
        "",
        "humidity-to-location map:",
        "60 56 37",
        "56 93 4",
        ))
}


private fun part1(input: List<String>): Long {
    val seeds = mutableListOf<Long>()
    val maps : MutableList<MutableMap<LongRange, LongRange>> = mutableListOf()
    var searchNumbers = false
    for(line in input) {
        if(line.split(": ").size == 2) {
            val stringList = line.split(": ")[1].split(" ")
            for(item in stringList) {
                seeds.add(item.toLong())
            }
        }

        else if(line.isEmpty()) {
            searchNumbers = false
        }

        else if(searchNumbers) {
            val mappingData : MutableList<Long> = mutableListOf()

            for(item in line.split(" ")) {
                mappingData.add(item.toLong())
            }

            maps.last()[mappingData[0]..< mappingData[0] + mappingData[2]] = mappingData[1]..< mappingData[1] + mappingData[2]
        }

        else if(line.contains("map")) {
            maps.add(mutableMapOf())
            searchNumbers = true
        }
    }

    for(map in maps) {
        map.println()
    }

    val minLocation = -1L
    for(seed in seeds) {
        for(input in maps[0].keys) {
            if(seed in input) {
                seed.println()
            }
        }
    }


    return 0
}