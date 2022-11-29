package net.pijcke.relationviz

import tornadofx.*

class RelationViz: App(MainView::class) {
}

fun main(args: Array<String>) {
    launch<RelationViz>(args)
}