# N-Queens Boardgame Solver (Java)

This project, written in **Java**, displays all possible solutions to the classic **N-Queens problem**, solved using **recursive backtracking**.

The program generates every possible way to place `N` queens on an `N x N` chessboard so that none of them can attack each other.  
Queens cannot share the same row, column, or diagonal.

---

## What does the code do?

1. The program asks the user for a number `N` → the board size.
2. It initializes an `N x N` board.
3. Automatically executes the backtracking algorithm:
    - Place one queen per row.
    - Check if the position is valid (no conflicts in columns or diagonals).
    - If valid, continue with the next row.
    - If not, backtrack and try another position.
4. Each valid configuration is printed to the console.
5. At the end, the total number of solutions is displayed.

Example with `N = 4`:

Enter a board size: 4

Results:

```
|1|3|0|2|

| |Q| | | 
| | | |Q|
|Q| | | |
| | |Q| |

|2|0|3|1|

| | |Q| |
|Q| | | |
| | | |Q|
| |Q| | |
```
Number of possible results: 2

