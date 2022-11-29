package net.pijcke.relationviz

class Relation(private val id: Int): tornadofx.Component() {
    fun asLatex(): String {
        throw NotImplementedError()
    }

    fun asText(): String {
        throw NotImplementedError()
    }

    fun isReflexive(): Boolean {
        throw NotImplementedError()
    }

    fun isSymmetric(): Boolean {
        throw NotImplementedError()
    }

    fun isTransitive(): Boolean {
        throw NotImplementedError()
    }
}
