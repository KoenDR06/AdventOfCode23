package puzzles

import println

fun main() {
//    part1(readInput("day7")).println()
//    part2(readInput("day6")).println()

    part1(listOf(
        "32T3K 765",
        "T55J5 684",
        "KK677 28",
        "KTJJT 220",
        "QQQJA 483",
    )).println()
}


private fun part1(input: List<String>) : Int {

    // Hand, Bid, Type (0-6)
    var hands : MutableMap<String, Pair<Int, Int>> = mutableMapOf()
    for(line in input) {
        val data = line.split(" ")
        hands[data[0]] = Pair(data[1].toInt(), 0)
    }


    for(hand in hands) {
        // Cards, Count
        val cards : MutableMap<Char, Int> = mutableMapOf()
        for(card in hand.key) {
            if(card in cards.keys) {
                cards[card] = cards[card]!! + 1
            } else {
                cards[card] = 1
            }
        }

        if(cards.size == 5) {
            hands[hand.key] = Pair(hands[hand.key]!!.first, 0)
        }
        else if(cards.size == 4) {
            hands[hand.key] = Pair(hands[hand.key]!!.first, 1)
        }
        else if(cards.size == 3) {
            if(cards.values.max() == 2) {
                hands[hand.key] = Pair(hands[hand.key]!!.first, 2)
            } else if(cards.values.max() == 3) {
                hands[hand.key] = Pair(hands[hand.key]!!.first, 3)
            }
        }
        else if(cards.size == 2) {
            if(cards.values.max() == 3) {
                hands[hand.key] = Pair(hands[hand.key]!!.first, 4)
            } else if(cards.values.max() == 4) {
                hands[hand.key] = Pair(hands[hand.key]!!.first, 5)
            }
        }
        else if(cards.size == 1) {
            hands[hand.key] = Pair(hands[hand.key]!!.first, 6)
        }
    }

    hands.println()
    val sortedMap = hands.toList()
        .sortedByDescending { it.second.second }
        .toMap()
    sortedMap.println()

    var sum = 0
    var rank = input.size

    val highestRankCards = sortedMap.entries.filter { it.value.second == sortedMap.values.first().second }
    highestRankCards.println()

    val cardList = listOf('A','K','Q','J','T','9','8','7','6','5','4','3','2')

    for(card in highestRankCards) {

    }

    return sum
}