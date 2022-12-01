package net.pijcke.relationviz

import javafx.scene.canvas.Canvas
import javafx.scene.control.Tooltip
import javafx.scene.paint.Color
import net.pijcke.relationviz.filters.BooleanFilter

class Relation(private val id: Int, private val pixelSide: Int = 13): Canvas(3 * pixelSide + 2.0, 3 * pixelSide + 2.0) {

    private var color = Color.BLACK

    init {
        init()
    }

    private fun init() {
        paint()

        val tooltip = Tooltip(asText())
        Tooltip.install(this, tooltip)
    }

    fun asLatex(): String {
        throw NotImplementedError()
    }

    private fun asText(): String {
        val parts = (0..2).flatMap { left -> (0..2).filter { right -> r(left, right) }.map { right -> asText(left, right) } }
        return parts.joinToString(", ", "{", "}")
    }

    private fun asText(left: Int, right: Int): String {
        val leftLetter = "abc"[left]
        val rightLetter = "abc"[right]
        return "R($leftLetter, $rightLetter)"
    }

    fun r(left: Int, right: Int): Boolean {
        assert(left in 0..2)
        assert(right in 0..2)

        val bit = left * 3 + right
        return (id shr bit) % 2 == 1
    }

    fun showHide(filters: List<BooleanFilter>): Boolean {
        val show = filters.all {
            (it.getState() == FilterEnum.Yes && it.apply(this)) ||
                    (it.getState() == FilterEnum.No && !it.apply(this) ||
                            it.getState() == FilterEnum.Either)
        }

        color = if (show) Color.BLACK else Color.LIGHTGRAY

        paint()

        return show
    }

    private fun paint() {
        val gc = graphicsContext2D

        graphicsContext2D.clearRect(0.0, 0.0, 3 * pixelSide.toDouble() + 2, 3 * pixelSide.toDouble() + 2)

        gc.stroke = Color.BLACK
        gc.strokeRect(1.0, 1.0, 3.0 * pixelSide, 3.0 * pixelSide)

        gc.fill = color
        for (left in 0..2) {
            for (right in 0..2) {
                if (r(left, right)) {
                    gc.fillRect(right * pixelSide + 1.0, left * pixelSide + 1.0, pixelSide.toDouble(), pixelSide.toDouble())
                }
            }
        }
    }
}
