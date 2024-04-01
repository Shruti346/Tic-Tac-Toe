
// Import the Scanner class for user input

import java.util.Scanner;

public class TicTacToe{

    // Define constants for the board size and the symbols
    public static final int BOARD_SIZE = 3;
    public static final char EMPTY = ' ';
    public static final char X = 'X';
    public static final char O = 'O';

    // Define variables for the board, the current player, and the scanner
    public static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    public static char currentPlayer = X;
    public static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {
        // Initialize the board with empty spaces
        initializeBoard();

        // Start the game loop
        while (true) {
            // Print the board
            printBoard();

            // Ask the current player to enter their move
            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
            int row = scanner.nextInt() - 1; // Subtract 1 to match the array index
            int col = scanner.nextInt() - 1;

            // Check if the move is valid
            if (isValidMove(row, col)) {
                // Update the board with the current player's symbol
                board[row][col] = currentPlayer;

                // Check if the current player has won
                if (checkWin(currentPlayer)) {
                    // Print the board and the winner
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break; // End the game loop
                }

                // Check if the board is full (tie)
                if (isBoardFull()) {
                    // Print the board and the result
                    printBoard();
                    System.out.println("It's a tie!");
                    break; // End the game loop
                }

                // Switch the current player
                switchPlayer();
            } else {
                // Invalid move, ask the player to try again
                System.out.println("Invalid move, try again.");
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Method to initialize the board with empty spaces
    public static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    // Method to print the board
    public static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

    // Method to check if a move is valid
    public static boolean isValidMove(int row, int col) {
        // Check if the row and col are within the board range and the position is empty
        return (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY);
    }

    // Method to check if the current player has won
    public static boolean checkWin(char symbol) {
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }

        // No win condition found
        return false;
    }

    // Method to check if the board is full
    public static boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to switch the current player
    public static void switchPlayer() {
        if (currentPlayer == X) {
            currentPlayer = O;
        } else {
            currentPlayer = X;
        }
    }
}
