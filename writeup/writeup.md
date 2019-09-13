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

 - \pgfplotsset{compat=1.5}
---
\noindent Brigham Campbell

\noindent Dr. Griffith

\noindent CS 2235

\noindent 11 September 2019

\begin{center}
Programming Assignment 01
\end{center}

\noindent PART 1

1. Note that $2n^3-7n^2+100n-36 \leq (2+7+100+36)n^3=cn^3$, for $c=145$, when $n \geq n_0=1$. Therefore, the function is $O(n^3)$.
2. Note that $10n+3log(n) \leq (10+3)n=cn$, for $c=13$, when $n \geq n_0=1$. Therefore, the function is $O(n)$.
3. Note that $n/1000 \leq (1/1000)n=cn$, for $c=1/1000$, when $n \geq n_0=1$. Therefore, the function is $O(n)$, not $O(1)$.
4. Note that $log(n)^2+log(n)/30 \leq (1+1/30)log(n)^2$, for $c=31/30$, when $n \geq n_0=2$. Therefore, the function is $O(log(n)^2)$.
5. Note that $n^2/log(n)+3n \leq (1+3)n^2$, for $c=4$, when $n \geq n_0=2$. Therefore, the function is $O(n^2)$.
6. The function is $O(n)$.
7. The function is $O(n^2)$.
8. The function is $O(n)$.
9. The function is $O(n)$.
10. The function is $O(1)$.
11. Function _m1FindLargest_ is $O(n)$. It loops through the domain fully just once, so the complexity is 1:1.
12. Function _m2PrintTriangle_ is $O(n)$. It loops through the domain fully just once, so the complexity is 1:1. This function is tricky because it contains a nested for loop, but the inner loop never repeats more or less than once.
13. Function _m3PrintBooks_ is $O(n)$. This function's complexity is harder to determine because the domain contains n, the size of the _books_ or _stars_ arrays, as well as n more axes, one axis for the value of each integer stored in the _stars_ array. I determined the complexity in respect to only the first axis, the size of the _books_ or _stars_ arrays.

\noindent PART 2

The following figure is the result of plotting the averages of the length of time four algorithms take to complete. The averages have been computed by running each function 200,000 times per array size.

\begin{center}
  \begin{tikzpicture}
    \begin{axis}[
      xlabel={Array Size(\# of elements)},
      ylabel={Average $\Delta$Time(nanoseconds)},
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

As the graph shows, Recursive Linear Search quickly becomes slower than the others as it's given larger arrays. By inspection, we see that Linear Search is in the same order as Recursive Linear Search, but is scaled such that it will take nearly one fourth the time that Recursive Linear Search will take for the same array size. This makes sense because rapid function calls impose significant overhead in Java.

Comparatively, both Binary Search and Recursive Binary Search take a very small amount of time to complete. This makes sense as Binary Search is $O(log(n))$ while Linear Search is $O(n)$. However, I was surprised to see that the recursive and iterative versions of the algorithm are very similar in timing. After seeing the drastic difference in the two Linear Search timings, I would expect the recursive implementation of Binary Search to take much longer than the iterative one as well.

From these results, we can conclude that some recursive or linear implementation of Binary Search is more efficient than Linear Search when searching through sorted data.
