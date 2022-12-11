package io.github.mwttg.adventofcode.day11

data class Monkey(
    val items: List<Int>,
    private val operation: (Int) -> Int,
    private val test: Triple<Int, Int, Int>,
    var inspectedItems: Int = 0,
) {
    fun addItem(items: Int) = this.copy(items = this.items + items)

    private fun getTargetMonkeyIndexForItem(item: Int) =
        if (item % test.first == 0) test.second else test.third

    fun getItemsWithTarget() = items.map {
        val item = operation(it) / 3
        val target = getTargetMonkeyIndexForItem(item)
        inspectedItems++
        Pair(item, target)
    }

    fun removeItems() = this.copy(items = listOf())

    fun print(monkeyIndex: Int) {
        println("Monkey $monkeyIndex: $items")
    }
}
