package net.pijcke.relationviz
import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.input.Clipboard
import javafx.scene.input.ClipboardContent
import javafx.scene.layout.HBox
import net.pijcke.relationviz.filters.IsReflexive
import net.pijcke.relationviz.filters.IsSymmetric
import net.pijcke.relationviz.filters.IsTransitive
import tornadofx.*

class MainView: View() {
    private val relations = (0..511).map { Relation(it) }

    private val filters = listOf(
        IsReflexive(),
        IsSymmetric(),
        IsTransitive(),
    )

    private val itemsShownCount = SimpleIntegerProperty(512)

    override val root = borderpane {
        top = HBox().also { filterBox ->
            filters.forEach { filter -> filterBox.children.add(filter.getControl()) }
            filterBox.children.add(
                button("Apply filters") {
                    action {
                        itemsShownCount.set(relations.count { it.showHide(filters) })
                    }
                }
            )
        }

        center = flowpane {
            children.addAll(relations)
        }

        bottom = hbox {
            label("Total : ")
            label(itemsShownCount)
            button("Copy LaTeX to clipboard") {
                action {
                    val latex = relations.filter { it.isShown() }.joinToString("\n") { it.asLatex() }
                    Clipboard.getSystemClipboard().setContent(ClipboardContent().also { it.putString(latex) })
                }
            }
        }
    }
}