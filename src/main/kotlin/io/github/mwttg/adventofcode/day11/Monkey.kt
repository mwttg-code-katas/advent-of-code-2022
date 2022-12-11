package io.github.mwttg.adventofcode.day11

data class Monkey(
    val items: List<Long>,
    private val operation: (Long) -> Long,
    private val test: Triple<Int, Int, Int>,
    var inspectedItems: Int = 0,
) {
    fun addItem(items: Long) = this.copy(items = this.items + items)

    private fun getTargetMonkeyIndexForItem(item: Long) =
        if (item % test.first == 0L) test.second else test.third

    fun getItemsWithTarget(ridiculousLevels: Boolean) = items.map {
        val item = if (ridiculousLevels) operation(it) % LCM else operation(it) / 3
        val target = getTargetMonkeyIndexForItem(item)
        inspectedItems++
        Pair(item, target)
    }

    fun removeItems() = this.copy(items = listOf())

    fun print(monkeyIndex: Int) {
        println("Monkey $monkeyIndex: inspected items: '$inspectedItems' currentItems = $items")
    }
}
