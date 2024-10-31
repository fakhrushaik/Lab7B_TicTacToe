public class Board {
    private char[][] board;
    private final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col, char marker) {
        if (board[row][col] == ' ') {
            board[row][col] = marker;
            return true;
        }
        return false;
    }

    public boolean checkWinCondition(char marker) {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == marker && board[i][1] == marker && board[i][2] == marker) ||
                    (board[0][i] == marker && board[1][i] == marker && board[2][i] == marker)) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) ||
                (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker);
    }

    public char[][] getBoard() {
        return board;
    }
}
