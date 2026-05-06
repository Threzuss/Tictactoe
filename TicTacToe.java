/**
 * TicTacToe
 * UC10: Detect Draw Condition
 * Detects when no moves remain by checking for empty cells on the board.
 */
public class TicTacToe {

    static char[][] board = new char[3][3];

    /**
     * Checks if the game is a draw.
     * Logic: If no cells contain '-', the board is full.
     * Note: This should always be called AFTER checking for a win.
     * 
     * @return true if the board is full, false otherwise.
     */
    public static boolean isDraw() {
        // Loop Traversal: Iterate through each row
        for (int row = 0; row < 3; row++) {
            // Iterate through each column in that row
            for (int col = 0; col < 3; col++) {
                // Boolean Flag logic: If an empty cell is found, it's not a draw
                if (board[row][col] == '-') {
                    return false; 
                }
            }
        }
        // If the loops complete without returning false, every cell is filled
        return true; 
    }

    // Sample main to test UC10 logic
    public static void main(String[] args) {
        // Manually filling the board to simulate a draw state
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) board[i][j] = 'X';
        }

        if (isDraw()) {
            System.out.println("Draw detected! No moves remaining.");
        } else {
            System.out.println("Game continues...");
        }
    }
}