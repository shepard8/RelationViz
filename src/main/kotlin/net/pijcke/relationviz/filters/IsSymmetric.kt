package net.pijcke.relationviz.filters

import net.pijcke.relationviz.Relation

class IsSymmetric: BooleanFilter("Symmetric") {
    override fun apply(relation: Relation): Boolean {
        return relation.r(0, 1) == relation.r(1, 0) &&
                relation.r(0, 2) == relation.r(2, 0) &&
                relation.r(1, 2) == relation.r(2, 1)
    }
}