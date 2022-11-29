package net.pijcke.relationviz
import javafx.scene.control.ToggleGroup
import tornadofx.*

class MainView: View() {
    private val relations = (0..511).map { Relation(it) }.asObservable()

    private val groupReflexive = ToggleGroup()
    private val groupSymmetric = ToggleGroup()
    private val groupTransitive = ToggleGroup()

    private val totalLabel = label()

    override val root = borderpane {
        top = hbox {
            label("Reflexive")
            radiobutton("yes", groupReflexive)
            radiobutton("no", groupReflexive)
            radiobutton("either", groupReflexive) {
                isSelected = true
            }

            label("Symmetric")
            radiobutton("yes", groupSymmetric)
            radiobutton("no", groupSymmetric)
            radiobutton("either", groupSymmetric) {
                isSelected = true
            }

            label("Transitive")
            radiobutton("yes", groupTransitive)
            radiobutton("no", groupTransitive)
            radiobutton("either", groupTransitive) {
                isSelected = true
            }
        }
        center = flowpane {
        }
        bottom = hbox {
            label("Total : ")
            totalLabel
            button("Copy LaTeX to clipboard")
        }
    }
}