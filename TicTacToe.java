import java.util.Random;

/**
 * TicTacToe
 * UC7 allows the computer to make a random valid move
 * by reusing slot conversion and validation logic.
 */
public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };
    static char computerSymbol = 'O';

    public static void main(String[] args) {
        // Trigger the computer move
        computerMove();
        // Print board to see the result
        printBoard();
    }

    /**
     * Generates random slot values until a valid move is found,
     * then places the computer symbol on the board.
     */
    static void computerMove() {
        Random random = new Random();
        boolean moved = false;

        while (!moved) {
            // Generate a random slot between 1 and 9
            int slot = random.nextInt(9) + 1;
            
            // Reuse UC4 logic to get indices
            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            // Reuse UC5 logic to validate
            if (isValidMove(row, col)) {
                // Reuse UC6 logic to place the symbol
                placeMove(row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                moved = true;
            }
        }
    }

    // --- Reused Logic from UC1, UC4, UC5, UC6 ---

    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    static boolean isValidMove(int row, int col) {
        return board[row][col] == '-';
    }

    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    static void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}