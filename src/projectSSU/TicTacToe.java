package projectSSU;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void playGame() {
        while (true) {
            printBoard();
            makeMove();
            if (hasWon()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a tie!");
                break;
            }
            switchPlayer();
        }
    }

    private static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | "); // Avoid trailing separator
            }
            System.out.println();
            if (i < 2) System.out.println("---------"); // Avoid extra line at the bottom
        }
    }

    private static void makeMove() {
        while (true) {
            try {
                System.out.println("Player " + currentPlayer + ", enter row (1-3):");
                int row = scanner.nextInt() - 1;
                System.out.println("Player " + currentPlayer + ", enter column (1-3):");
                int col = scanner.nextInt() - 1;

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid move, try again.");
                } else if (board[row][col] != '-') {
                    System.out.println("Position already occupied, try again.");
                } else {
                    board[row][col] = currentPlayer;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numbers between 1 and 3.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static boolean hasWon() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}

