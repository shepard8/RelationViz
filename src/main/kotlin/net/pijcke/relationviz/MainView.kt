package net.pijcke.relationviz
import tornadofx.*

class MainView: View() {
    override val root = vbox {
        button("press me")
        label("Waiting")
    }
}