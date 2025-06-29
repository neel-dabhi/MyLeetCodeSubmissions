class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<String>();

        for(int i=0; i< board.length; i++){
            for(int j=0; j < board[0].length; j++){

                if(board[i][j] != '.'){
                    String rowString = "r" + i + board[i][j];
                    String colString = "c" + j + board[i][j];
                    String gridString = "b" + (i/3) + "" + (j/3) + board[i][j];

                
                    if(set.contains(rowString) || set.contains(colString) || set.contains(gridString) ){
                        return false;
                    }
                    set.add(rowString);
                    set.add(colString);
                    set.add(gridString);
                }
            }
        }

        return true;
    }
}