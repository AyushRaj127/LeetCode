class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean findWord(int row, int col, int index, char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= n || col >= m || board[row][col] != word.charAt(index) || board[row][col] == '?') {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '?';

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (findWord(newRow, newCol, index + 1, board, word)) {
                return true;
            }
        }

        board[row][col] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && findWord(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }
}