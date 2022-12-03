# RelationViz

This small UI in Kotlin + TornadoFX has initially been developped in order to solve exercise 1.1.7 of the book A First Course in Group Theory by Bijan Davvaz.

It shows all binary relations on {a, b, c} \times {a, b, c} in the form of 3 \times 3 matrices of white/black squares.

The UI allows to select only the relations that are reflexive or not, only the relations that are symmetric or not, and only the relations that are transitive or not (or a combination of these).

Finally, there is an "Export as LaTeX" button which produces a LaTeX fragment displaying the selected relations. In order for these to show correctly, the following LaTeX preamble must be present:

[TODO]
