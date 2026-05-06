import java.util.Scanner;

/**
 * TicTacToe
 * UC2 implements the core game loop and handles basic user input.
 * It introduces the Scanner class for reading console input and a while loop
 * to keep the game running until a condition is met (which we will add later).
 */
public class TicTacToe {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X'; // Start with player X

    public static void main(String[] args) {
        initializeBoard();
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("Welcome to Tic-Tac-Toe!");

        // The Game Loop
        while (gameRunning) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1-3): ");

            // Read user input (subtracting 1 because arrays are 0-indexed)
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Basic validation (we will improve this in the next use case)
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("This move is not valid. Try again.");
            }
            
            // For now, let's just let them play 9 moves (we'll add win logic later)
            // This is just to test the loop and input.
             if(isBoardFull()){
                 printBoard();
                 System.out.println("Board is full. Game Over.");
                 gameRunning = false;
             }
        }
        scanner.close();
    }

    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    // Helper method to check if the board is full to prevent infinite loop for now
    static boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}