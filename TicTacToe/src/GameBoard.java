public class GameBoard {
    private String[][] board;
    public static final int size = 3;

    public GameBoard() {
        initializeBoard();
    }

    public boolean makeMove(int row, int col, String symbol) {
        if (isValidMove(row, col) && isCellEmpty(row, col)) {
            board[row][col] = symbol;
            return true; // Move is valid
        } else {
            return false; // Move is invalid
        }
    }
    
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].equals("-")) {
                    return false; // There is an empty cell, the board is not full
                }
            }
        }
        return true; // Board is full
    }

    public void printBoard() {
        System.out.println("----0---1---2--");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------");
        }
    }

    private void initializeBoard() {
        board = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "-";
            }
        }
    }

    private boolean isCellEmpty(int row, int col) {
        return board[row][col].equals("-");
    }

    private boolean checkRows() {
        for (int i = 0; i < size; i++) {
            if (!board[i][0].equals("-") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return true; // Row is a win
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int j = 0; j < size; j++) {
            if (!board[0][j].equals("-") && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
                return true; // Column is a win
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (!board[0][0].equals("-") && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) ||
               (!board[0][2].equals("-") && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]));
    }
}
