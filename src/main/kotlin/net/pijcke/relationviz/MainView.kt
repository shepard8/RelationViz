package net.pijcke.relationviz
import javafx.scene.control.ToggleGroup
import tornadofx.*

class MainView: View() {
    private val relations = (0..511).map { Relation(it) }

    private val groupReflexive = ToggleGroup()
    private val groupSymmetric = ToggleGroup()
    private val groupTransitive = ToggleGroup()

    private var reflexiveFilter = FilterEnum.Either
    private var symmetricFilter = FilterEnum.Either
    private var transitiveFilter = FilterEnum.Either

    private val totalLabel = label()

    override val root = borderpane {
        top = hbox {
            label("Reflexive")
            radiobutton("yes", groupReflexive) {
                action { reflexiveFilter = FilterEnum.Yes }
            }
            radiobutton("no", groupReflexive) {
                action { reflexiveFilter = FilterEnum.No }
            }
            radiobutton("either", groupReflexive) {
                isSelected = true
                action { reflexiveFilter = FilterEnum.Either }
            }

            label("Symmetric")
            radiobutton("yes", groupSymmetric) {
                action { symmetricFilter = FilterEnum.Yes }
            }
            radiobutton("no", groupSymmetric) {
                action { symmetricFilter = FilterEnum.No }
            }
            radiobutton("either", groupSymmetric) {
                isSelected = true
                action { symmetricFilter = FilterEnum.Either }
            }

            label("Transitive")
            radiobutton("yes", groupTransitive) {
                action { transitiveFilter = FilterEnum.Yes }
            }
            radiobutton("no", groupTransitive) {
                action { transitiveFilter = FilterEnum.No }
            }
            radiobutton("either", groupTransitive) {
                isSelected = true
                action { transitiveFilter = FilterEnum.Either }
            }

            button("Apply filters") {
                action {
                    relations.forEach { it.showHide(reflexiveFilter, symmetricFilter, transitiveFilter) }
                }
            }
        }
        center = flowpane {
            children.addAll(relations)
        }
        bottom = hbox {
            label("Total : ")
            totalLabel
            button("Copy LaTeX to clipboard")
        }
    }
}