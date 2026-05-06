/**
 * TicTacToe
 * UC9: Check Winning Condition
 * Detects if a player has won the game by checking rows, columns, and diagonals.
 */
public class TicTacToe {

    static char[][] board = new char[3][3];

    // Master method to check all win conditions
    public static boolean isWin(char symbol) {
        return (checkRows(symbol) || checkCols(symbol) || checkDiagonals(symbol));
    }

    // 1. Check all three rows
    private static boolean checkRows(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        return false;
    }

    // 2. Check all three columns
    private static boolean checkCols(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        return false;
    }

    // 3. Check the two diagonals
    private static boolean checkDiagonals(char symbol) {
        // Left-to-Right diagonal
        boolean diag1 = (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol);
        // Right-to-Left diagonal
        boolean diag2 = (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
        
        return diag1 || diag2;
    }

    // Sample main to test UC9 logic specifically
    public static void main(String[] args) {
        // Mock a win for player 'X' in the first row
        board[0][0] = 'X'; board[0][1] = 'X'; board[0][2] = 'X';
        
        if (isWin('X')) {
            System.out.println("Win detected for Player X!");
        } else {
            System.out.println("No win detected.");
        }
    }
}