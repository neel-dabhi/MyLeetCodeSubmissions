class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helpSolveNQueens(board, 0, result);
        return result;
    }

    private void helpSolveNQueens(boolean[][] board, int row, List<List<String>> result){
        // base cases
        int n = board.length;
        if(row == n){
            result.add(covertBoardToList(board));
            return;
        }

        // for row check every col if its valid to place queen
        for(int j=0; j<n; j++){
            if(isSafe(board, row, j)){
                board[row][j] = true;
                helpSolveNQueens(board,row + 1, result);
                board[row][j] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int col){
        int n = board.length;

        // check col above
        for(int i=0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }

        // check row before
        for(int i=0; i<col; i++){
            if(board[row][i]){
                return false;
            }
        }

        // check diagonal up left
        int r = row;
        int c = col;
        while( r >= 0 && c >= 0){
            if(board[r][c]){
                return false;
            }
            r--;
            c--;
        }

        // check diagonal up right
        r = row;
        c = col;

        while( r >= 0 && c < n){
            if(board[r][c]){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    private List<String> covertBoardToList(boolean[][] board){
        int n = board.length;
        List<String> fullBoard = new ArrayList<>(); 
        
        for(int i=0; i<n; i++){
            StringBuilder row = new StringBuilder();
            for(int j=0; j<n; j++){
                if(board[i][j]){
                    row.append('Q');
                }else{
                    row.append('.');
                }
            }
            fullBoard.add(row.toString());
        }
        return fullBoard;
    }
}