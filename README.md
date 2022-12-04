# RelationViz

This small UI in Kotlin + TornadoFX has initially been developped in order to solve exercise 1.1.7 of the book **A First Course in Group Theory** by *Bijan Davvaz*.

It shows all binary relations on $\\{a, b, c\\} \times \\{a, b, c\\}$ in the form of $3 \times 3$ matrices of white/black squares.

![2022-12-04-141927_956x1044_scrot](https://user-images.githubusercontent.com/5731430/205492838-4351c73f-9db7-4ee5-9398-75f700e7e945.png)

The UI allows to select only the relations that are reflexive or not, only the relations that are symmetric or not, and only the relations that are transitive or not (or a combination of these).

Finally, there is an "Export as LaTeX" button which produces a LaTeX fragment displaying the selected relations. In order for these to show correctly, the following LaTeX preamble must be present:

```latex
\usepackage{tikz}

\tikzset{rel/.pic={
  \begin{scope}[scale=0.1]
    \foreach \left in {0,1,2} {
      \foreach \right in {0,1,2} {
        \pgfmathsetmacro{\colour}{(mod(div(#1, pow(2, (3 * \right + \left))), 2)) ? "black" : "none"}
        \draw[fill=\colour] (\left,\right) rectangle ++ (1,1);
      }
    }
  \end{scope}
}}
```
