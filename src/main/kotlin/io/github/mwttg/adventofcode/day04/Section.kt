package io.github.mwttg.adventofcode.day04

data class Section(val startInclusive: Int, val endInclusive: Int) {

    // this Sections overlaps completely the other Section, or the other Section overlaps completely this Section
    fun overlapsComplete(other: Section): Boolean =
        if (this.startInclusive <= other.startInclusive && this.endInclusive >= other.endInclusive)
            true
        else
            other.startInclusive <= this.startInclusive && other.endInclusive >= this.endInclusive

    fun overlaps(other: Section): Boolean =
        if (other.startInclusive >= this.startInclusive && other.startInclusive <= this.endInclusive)
            true
        else if (other.endInclusive >= this.startInclusive && other.endInclusive <= this.endInclusive)
            true
        else if (this.startInclusive >= other.startInclusive && this.startInclusive <= other.endInclusive)
            true
        else this.endInclusive >= other.startInclusive && this.endInclusive <= other.endInclusive


    companion object {

        fun createFrom(text: String): Pair<Section, Section> {
            val sections = text.split(",")
            val s1 = sections[0].split("-")
            val s2 = sections[1].split("-")
            return Pair(
                Section(s1[0].toInt(), s1[1].toInt()),
                Section(s2[0].toInt(), s2[1].toInt())
            )
        }
    }
}
