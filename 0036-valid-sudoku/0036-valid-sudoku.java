class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char curr = board[row][col];

                if (curr == '.') {
                    continue;
                }

                String currR = curr + "R" + Integer.toString(row);
                String currC = curr + "C" + Integer.toString(col);
                String currB = curr + "R" + Integer.toString(row / 3) + Integer.toString(col / 3);

                if (set.contains(currR) || set.contains(currC) || set.contains(currB)) {
                    return false;
                }

                set.add(currR);
                set.add(currC);
                set.add(currB);
            }
        }
        return true;
    }
}