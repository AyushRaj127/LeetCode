class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            
            for (int col = 0; col < 9; col++) {
                if (seen.contains(board[row][col])) {
                    return false;
                }

                if (board[row][col] != '.') {
                    seen.add(board[row][col]);
                }
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            
            for (int row = 0; row < 9; row++) {
                if (seen.contains(board[row][col])) {
                    return false;
                }

                if (board[row][col] != '.') {
                    seen.add(board[row][col]);
                }
            }
        }

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                Set<Character> seen = new HashSet<>();

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (seen.contains(board[i][j])) {
                            return false;
                        }

                        if (board[i][j] != '.') {
                            seen.add(board[i][j]);
                        }
                    }
                }
            }
        }

        return true;
    }
}