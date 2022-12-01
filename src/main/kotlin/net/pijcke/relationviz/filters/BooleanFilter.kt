package net.pijcke.relationviz.filters

import javafx.scene.control.ToggleGroup
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import net.pijcke.relationviz.FilterEnum
import net.pijcke.relationviz.Relation
import tornadofx.*

abstract class BooleanFilter(val title: String) {

    private val group = ToggleGroup()
    private var state: FilterEnum = FilterEnum.Either

    fun getControl(): Pane {
        return HBox().apply {
            label(title)
            radiobutton("yes", group) {
                action { state = FilterEnum.Yes }
            }
            radiobutton("no", group) {
                action { state = FilterEnum.No }
            }
            radiobutton("either", group) {
                isSelected = true
                action { state = FilterEnum.Either }
            }
        }
    }

    fun getState(): FilterEnum = state

    abstract fun apply(relation: Relation): Boolean
}