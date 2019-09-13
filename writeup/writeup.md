---
indent: true
geometry: margin=1in
fontsize: 12pt
header-includes: 
 - \usepackage{pgfplots}
 - \usepackage{pgfplotstable}
 - \usepackage{fancyhdr}
 - \usepackage{setspace}

 - \pagestyle{fancy}
 - \fancyhf{}
 - \fancyhead[R]{Campbell \thepage}
 - \renewcommand{\headrulewidth}{0pt}
 
 - \doublespacing

---
\noindent Brigham Campbell

\noindent Dr. Griffith

\noindent CS 2235

\noindent 11 September 2019

\begin{center}
Programming Assignment 01
\end{center}

Hello, World!

\begin{center}
  \begin{tikzpicture}
    \begin{axis}[
      xlabel={Array Size(\# of elements)},
      ylabel={$\Delta$Time(nanoseconds)},
      legend entries={Binary Search,Linear Search,Recursive Binary Search,Recursive Linear Search},
      legend style={
        at={(0.02,0.98)},
        anchor=north west},
      width=4.5in,
      height=4.5in]
      \addplot table[x=arraySize, y = BinarySearch, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y = LinearSearch, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y = RecursiveBinarySearch, col sep = comma] {timings.csv};
      \addplot table[x=arraySize, y = RecursiveLinearSearch, col sep = comma] {timings.csv};
    \end{axis}
  \end{tikzpicture}
\end{center}

