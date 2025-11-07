class Solution {
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visisted = new boolean[n][m];
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < n && !result; i++) {
            for (int j = 0; j < m && !result; j++) {
                if (board[i][j] == word.charAt(0)) {
                    helper(board, i, j, word, 0, dirs, visisted);
                }
            }
        }
        return result;
    }

    private void helper(char[][] board, int r, int c, String word, int idx, int[][] dirs, boolean[][] visisted) {
        // base 
        if (idx == word.length() -1) {
            result = true;
            return;
        }

        visisted[r][c] = true;

        for (int[] dir : dirs) {
            int row = r + dir[0];
            int col = c + dir[1];
            if ( row >= 0 && row < board.length && col >= 0 && col < board[0].length && 
                board[row][col] == word.charAt(idx + 1) && !visisted[row][col]) {
                helper(board, row, col, word, idx + 1, dirs, visisted);
            }
        }

        visisted[r][c] = false;
    }
}