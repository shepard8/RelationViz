package net.pijcke.relationviz

import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color

class Relation(private val id: Int, private val pixelSide: Int = 13): Canvas(3 * pixelSide + 2.0, 3 * pixelSide + 2.0) {

    private var color = Color.BLACK

    init {
        paint()
    }

    fun asLatex(): String {
        throw NotImplementedError()
    }

    fun asText(): String {
        throw NotImplementedError()
    }

    fun isReflexive(): Boolean {
        return r(0, 0) && r(1, 1) && r(2, 2)
    }

    fun isSymmetric(): Boolean {
        return r(0, 1) == r(1, 0) &&
                r(0, 2) == r(2, 0) &&
                r(1, 2) == r(2, 1)
    }

    fun isTransitive(): Boolean {
        for (a in 0..2) {
            for (b in 0..2) {
                if (r(a, b)) {
                    for (c in 0..2) {
                        if (r(b, c) && !r(a, c)) {
                            return false
                        }
                    }
                }
            }
        }

        return true
    }

    private fun r(left: Int, right: Int): Boolean {
        assert(left in 0..2)
        assert(right in 0..2)

        val bit = left * 3 + right
        return (id shr bit) % 2 == 1
    }

    fun showHide(reflexive: FilterEnum, symmetric: FilterEnum, transitive: FilterEnum): Boolean {
        val show = !(reflexive == FilterEnum.Yes && !isReflexive()) &&
                !(reflexive == FilterEnum.No && isReflexive()) &&
                !(symmetric == FilterEnum.Yes && !isSymmetric()) &&
                !(symmetric == FilterEnum.No && isSymmetric()) &&
                !(transitive == FilterEnum.Yes && !isTransitive()) &&
                !(transitive == FilterEnum.No && isTransitive())

        color = if (show) Color.BLACK else Color.LIGHTGRAY

        paint()

        return show
    }

    fun paint() {
        val gc = graphicsContext2D

        graphicsContext2D.clearRect(0.0, 0.0, 3 * pixelSide.toDouble() + 2, 3 * pixelSide.toDouble() + 2)

        gc.stroke = Color.BLACK
        gc.strokeRect(1.0, 1.0, 3.0 * pixelSide, 3.0 * pixelSide)

        gc.fill = color
        for (a in 0..2) {
            for (b in 0..2) {
                if (r(a, b)) {
                    gc.fillRect(a * pixelSide + 1.0, b * pixelSide + 1.0, pixelSide.toDouble(), pixelSide.toDouble())
                }
            }
        }
    }
}
