package io.github.mwttg.adventofcode.day03

data class Rucksack(val compartment1: CharSequence, val compartment2: CharSequence) {

    fun getMisplacedItem() = compartment1.toSet().intersect(compartment2.toSet()).elementAt(0)

    fun getPriorityOfMisplacedItem() = getPriorityOf(getMisplacedItem())

    companion object {

        fun createFrom(items: String): Rucksack {
            val compartment1 = items.subSequence(0, items.length / 2)
            val compartment2 = items.subSequence(items.length / 2, items.length)
            return Rucksack(compartment1, compartment2)
        }

        fun getPriorityOf(c: Char) = when (c.isLowerCase()) {
            true -> c.code - 96
            false -> c.code - 38
        }
    }
}
