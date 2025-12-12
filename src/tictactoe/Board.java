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

        String horizontal = "-".repeat(SIZE + (SIZE -1) * 3);

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

}


