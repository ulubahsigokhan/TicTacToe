package tictactoe;

// Board class represents the 3x3 grid of the game.
// It stores the current state of each cell,
// allows moves to be placed,
// checks if positions are valid or occupied,
// displays the board to the player,
// and detects win or draw conditions.

public class Board {

    final int SIZE = 3;
    String seperator;

    // The board will be stored as a 3x3 array of characters.
    // Each position will hold 'X', 'O', or a space ' ' for empty.
    private char[][] board;

    // Constructor
    public Board() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * This method prints the board to the console
     */
    public void printBoard() {

        String horizontal = "-".repeat(SIZE + (SIZE - 1) * 3);

        for (int i = 0; i < SIZE; i++) {

            // Print each cell in the row
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);

                // Print vertical separators between columns
                if (j != SIZE - 1) {
                    System.out.print(" | ");
                }
            }

            // Move to next line after finishing the row
            System.out.println();

            // Print horizontal separator between rows
            if (i != SIZE - 1) {
                System.out.println(horizontal);
            }
        }
    }

    /**
     * This methods checks if row and col are within the bounds and
     * if the chosen cell is empty. It places the symbol and if true indicates success.
     *
     * @param row
     * @param col
     * @param symbol
     * @return
     */
    public boolean placeMove(int row, int col, char symbol) {
        // Checks if row is within bounds
        if (row < 0 || row >= SIZE) {
            return false;
        }
        // Checks if col is within bounds
        if (col < 0 || col >= SIZE) {
            return false;
        }
        // Checks if the choosen cell is empty
        if (board[row][col] != ' ') {
            return false;
        }
        // Placing the symbol
        board[row][col] = symbol;

        // Indicate success
        return true;
    }

    /**
     * This method goes true the rows and columns and also diagonal/anti-diagonal
     * to check which player is the winner
     * @return
     */
    public boolean checkWinner() {
        // Rows check
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] != ' ' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {
                return true;
            }
        }
        // Cols check
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] != ' ' &&
                    board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i]) {
                return true;
            }
        }
        // Diagonal check
        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return true;
        }
        // Anti-diagonal check
        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the game is a draw
     * A draw means the board is full and no player has won
     * @return
     */
    public boolean isDraw() {
        // If there is a winner, it cannot be a draw
        if (checkWinner()) {
            return false;
        }
        // Check if any empty space remains
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        // No winner and no empty spaces -> draw
        return true;
    }

}

