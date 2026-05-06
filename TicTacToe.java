import java.util.Scanner;
import java.util.Random;

/**
 * TicTacToe
 * UC8 implements a continuous turn-based game loop that runs 
 * until a win or draw is detected.
 */
public class TicTacToe {

    static char[][] board = new char[3][3];
    static char humanSymbol;
    static char computerSymbol;
    static boolean isHumanTurn;

    public static void main(String[] args) {
        initializeBoard();
        tossAndAssignSymbols();
        
        boolean gameRunning = true;

        while (gameRunning) {
            printBoard();
            
            if (isHumanTurn) {
                System.out.println("--- Your Turn ---");
                int slot = getUserSlot();
                int row = getRowFromSlot(slot);
                int col = getColFromSlot(slot);

                if (isValidMove(row, col)) {
                    placeMove(row, col, humanSymbol);
                    if (checkWin(humanSymbol)) {
                        printBoard();
                        System.out.println("Congratulations! You won!");
                        gameRunning = false;
                    } else if (checkDraw()) {
                        printBoard();
                        System.out.println("It's a draw!");
                        gameRunning = false;
                    }
                    isHumanTurn = false; // Switch to computer
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            } else {
                System.out.println("--- Computer's Turn ---");
                computerMove();
                if (checkWin(computerSymbol)) {
                    printBoard();
                    System.out.println("Computer wins! Better luck next time.");
                    gameRunning = false;
                } else if (checkDraw()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameRunning = false;
                }
                isHumanTurn = true; // Switch to human
            }
        }
    }

    // --- Win and Draw Logic ---

    static boolean checkWin(char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    static boolean checkDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') return false;
            }
        }
        return true;
    }

    // --- Reused methods from UC1-UC7 ---
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) board[i][j] = '-';
        }
    }

    static void tossAndAssignSymbols() {
        isHumanTurn = new Random().nextBoolean();
        humanSymbol = isHumanTurn ? 'X' : 'O';
        computerSymbol = (humanSymbol == 'X') ? 'O' : 'X';
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) System.out.print(board[i][j] + " | ");
            System.out.println("\n-------------");
        }
    }

    static int getUserSlot() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        return sc.nextInt();
    }

    static int getRowFromSlot(int slot) { return (slot - 1) / 3; }
    static int getColFromSlot(int slot) { return (slot - 1) % 3; }
    static boolean isValidMove(int r, int c) { return board[r][c] == '-'; }
    static void placeMove(int r, int c, char s) { board[r][c] = s; }

    static void computerMove() {
        Random rand = new Random();
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int r = getRowFromSlot(slot);
            int c = getColFromSlot(slot);
            if (isValidMove(r, c)) {
                placeMove(r, c, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }
}