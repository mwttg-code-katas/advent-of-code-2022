package io.github.mwttg.adventofcode.day11

object Round {

    fun execute(monkeys: MutableMap<Int, Monkey>) {
        for (index in 0 until monkeys.size) {
            val monkey = monkeys[index]
            val itemsWithTarget = monkey!!.getItemsWithTarget()
            distributeItems(itemsWithTarget, monkeys)
            val updatedSourceMonkey = monkey.removeItems()
            monkeys[index] = updatedSourceMonkey
        }
    }

    private fun distributeItems(
        itemsWithTarget: List<Pair<Int, Int>>,
        monkeys: MutableMap<Int, Monkey>,
    ) {
        itemsWithTarget.forEach {
            val (item, target) = it
            monkeys[target] = monkeys[target]!!.addItem(item)
        }
    }

    fun print(monkeys: Map<Int, Monkey>) {
        for (index in 0 until monkeys.size) {
            monkeys[index]!!.print(index)
        }
    }
}