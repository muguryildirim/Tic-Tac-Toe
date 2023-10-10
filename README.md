## Tic-Tac-Toe Game

This is a simple implementation of the classic Tic-Tac-Toe game in Java using Swing. Players can take turns to make their moves, and the game checks for a winner or a tie.

### Features

- Two players can take turns to play the game.
- The game checks for a win or a tie.
- Winning cells are highlighted in green.
- It displays a message when the game ends.

### Technologies Used

- Java
- Swing (for the graphical user interface)

### Getting Started

1. Clone this repository to your local machine using `git clone`.
2. Compile and run the `Main.java` file.

### How to Play

- Players take turns to click on empty cells to make their move.
- The game will display a message when a player wins or when it's a tie.
- To start a new game, close the current window and run the program again.

### Code Structure

### `Game.java` Class

The `Game.java` class is the core component of this Tic-Tac-Toe application. It handles the game's logic, user interface, and player interactions.

#### Member Variables

- `frame`: The main application window.
- `titlePanel`: The panel at the top of the window containing the game title.
- `buttonPanel`: The panel containing the 3x3 grid of buttons for the game board.
- `textfield`: The label displaying the game status (e.g., "X's Turn" or "O's Turn").
- `buttons`: An array of buttons representing the game board cells.
- `isXTurn`: A boolean variable to keep track of which player's turn it is (true for X, false for O).

#### Constructor

- The constructor `Game()` initializes the game's graphical user interface, including setting up the main window, title panel, and button panel. It also sets the initial game state by calling `firstTurn()`.

#### `actionPerformed` Method

- The `actionPerformed(ActionEvent e)` method is called when a button on the game board is clicked. It handles player moves, toggles the turn between X and O, updates the game status, and checks for a win or a tie by calling the `checkWin()` method.

#### `checkWin` Method

- The `checkWin()` method checks for a winning condition in the game by examining all possible winning combinations of cells. If a winning combination is found, it highlights the winning cells in green, disables all buttons, and displays a message indicating the winner.

#### `highlightWinningCells` Method

- The `highlightWinningCells(int a, int b, int c)` method highlights the winning cells (buttons) with a green background color. It is called when a player wins the game.

#### `disableButtons` Method

- The `disableButtons()` method disables all buttons on the game board when the game ends.

#### `isBoardFull` Method

- The `isBoardFull()` method checks if the game board is full, indicating a tie. It returns `true` if all cells are filled, and `false` otherwise.

#### `firstTurn` Method

- The `firstTurn()` method randomly selects the starting player (X or O) and sets the initial game status accordingly.

This class serves as the heart of the Tic-Tac-Toe game, managing game state and player interactions.

### `Main.java` Class

Contains the `main` method to start the game.
