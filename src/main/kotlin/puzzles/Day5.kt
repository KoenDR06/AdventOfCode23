package puzzles

import print
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
        "52 50 48"
    )).println()

//    part1(listOf(
//        "seeds: 79 14 55 13",
//        "",
//        "seed-to-soil map:",
//        "50 98 2",
//        "52 50 48",
//        "",
//        "soil-to-fertilizer map:",
//        "0 15 37",
//        "37 52 2",
//        "39 0 15",
//        "",
//        "fertilizer-to-water map:",
//        "49 53 8",
//        "0 11 42",
//        "42 0 7",
//        "57 7 4",
//        "",
//        "water-to-light map:",
//        "88 18 7",
//        "18 25 70",
//        "",
//        "light-to-temperature map:",
//        "45 77 23",
//        "81 45 19",
//        "68 64 13",
//        "",
//        "temperature-to-humidity map:",
//        "0 69 1",
//        "1 0 69",
//        "",
//        "humidity-to-location map:",
//        "60 56 37",
//        "56 93 4",
//        )).println()
}


private fun part1(input: List<String>): Long {
    val seeds : MutableList<MutableList<Long>> = mutableListOf()
    seeds.add(mutableListOf())
    val maps : MutableList<MutableMap<Pair<Long, Long>, Pair<Long, Long>>> = mutableListOf()
    var searchNumbers = false
    for(line in input) {
        if(line.split(": ").size == 2) {
            val stringList = line.split(": ")[1].split(" ")
            for(item in stringList) {
                seeds.last().add(item.toLong())
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

            maps.last()[Pair(mappingData[1], mappingData[1] + mappingData[2])] = Pair(mappingData[0], mappingData[0] + mappingData[2])
            Pair(mappingData[1], mappingData[1] + mappingData[2]).println()
            Pair(mappingData[0], mappingData[0] + mappingData[2]).println()
            println()
        }

        else if(line.contains("map")) {
            maps.add(mutableMapOf())
            searchNumbers = true
        }
    }

    for(map in maps) {
        seeds.add(mutableListOf())
        for(seed in seeds[seeds.size - 2]) {
            var seedChecked = false
            for(entry in map) {
                val index = getIndexOfSeed(seed, entry.key)
                entry.println()
                if(index != -1) {
                    seeds.last().add(entry.value.first + seed)
                    seedChecked = true
                }
            }
            if(!seedChecked) {
                seeds.last().add(seed)
            }
        }
    }


    return seeds.last().min()
}

fun getIndexOfSeed(seed:Long, entry:Pair<Long, Long>) : Int {
    if(entry.first <= seed && seed < entry.second) {
        seed.println()
        entry.println()
        (seed - entry.first).toInt().println()
        println()
        return (seed - entry.first).toInt()
    } else {
        return -1
    }
}