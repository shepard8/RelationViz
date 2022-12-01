package net.pijcke.relationviz.filters

import net.pijcke.relationviz.Relation

class IsReflexive: BooleanFilter("Reflexive") {
    override fun apply(relation: Relation): Boolean {
        return relation.r(0, 0) && relation.r(1, 1) && relation.r(2, 2)
    }
}