class Solution {
    private int count = 0;
    private char[][] board;

    private boolean isSafe(int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void queens(int n, int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, n)) {
                board[row][col] = 'Q';
                queens(n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public int totalNQueens(int n) {
        count = 0;
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        queens(n, 0);
        return count;
    }
}