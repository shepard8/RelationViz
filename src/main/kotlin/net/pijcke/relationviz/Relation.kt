package net.pijcke.relationviz

import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color

class Relation(private val id: Int): Canvas(30.0, 30.0) {

    init {
        val gc = graphicsContext2D
        gc.fill = Color.RED
        gc.fillRect(1.0, 1.0, 28.0, 28.0)
    }

    fun asLatex(): String {
        throw NotImplementedError()
    }

    fun asText(): String {
        throw NotImplementedError()
    }

    fun isReflexive(): Boolean {
        // TODO
        return true
    }

    fun isSymmetric(): Boolean {
        // TODO
        return true
    }

    fun isTransitive(): Boolean {
        // TODO
        return true
    }
}
