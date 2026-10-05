class Solution {
    private char[][] board;

    private boolean isSafe(int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void queens(int n, int row, List<List<String>> result, List<String> current) {
        if (row == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, n)) {
                board[row][col] = 'Q';

                String place = new String(board[row]);

                current.add(place);
                queens(n, row + 1, result, current);

                current.remove(current.size() - 1);
                board[row][col] = '.';
            }
        }
    }

    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        queens(n, 0, result, current);
        return result.size();
    }
}