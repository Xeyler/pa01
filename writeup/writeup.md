---
title: Programming Assignment 01
author: Brigham Campbell
professor: Dr. Griffith
class: CS 2235
date: 12 September 2019
---
---
geometry: margin=1in
indent: true
header-includes:
  - \usepackage{pgfplots}
  - \usepackage{pgfplotstable}
---

# Part 1

# Part 2

\begin{center}
  \begin{tikzpicture}
    \begin{axis}[
      xlabel={Array Size(\# of elements)},
      ylabel={$\Delta Time(nanoseconds)$},
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

