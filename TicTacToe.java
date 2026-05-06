/**
 * TicTacToe
 * UC5 validates whether a move is inside the board boundaries 
 * and whether the selected cell is empty.
 */
public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    /**
     * Entry point of the program. Tests the validation logic
     * using sample row and column values.
     */
    public static void main(String[] args) {
        // Testing a valid move in the center of the board
        System.out.println("Is move (1,1) valid? " + isValidMove(1, 1));
    }

    /**
     * Checks if the given row and column are within bounds
     * and if the target cell is empty.
     * Input: Row, Column
     * Output: true if valid, false otherwise.
     */
    static boolean isValidMove(int row, int col) {
        // First, check if the indices are within the 0-2 range
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            // Second, check if the cell is empty (contains '-')
            return board[row][col] == '-';
        }
        // If either condition fails, it's not a valid move
        return false;
    }
}