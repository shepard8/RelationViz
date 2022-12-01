package net.pijcke.relationviz.filters

import net.pijcke.relationviz.Relation

class IsTransitive: BooleanFilter("Transitive") {
    override fun apply(relation: Relation): Boolean {
        for (a in 0..2) {
            for (b in 0..2) {
                if (relation.r(a, b)) {
                    for (c in 0..2) {
                        if (relation.r(b, c) && !relation.r(a, c)) {
                            return false
                        }
                    }
                }
            }
        }

        return true
    }
}