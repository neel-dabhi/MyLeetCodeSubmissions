// TC: O(n)
// SC: O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int idx = 0;

        for (int i = 0; i < instructions.length(); i++) {
            char command = instructions.charAt(i);

            if (command == 'G') {
                x = x + dirs[idx][0];
                y = y + dirs[idx][1];
            } else if (command == 'L') {
                idx = (idx +1) % 4;
            } else if (command == 'R') {
                idx = (idx +3) % 4;
            }
        }

        if(idx != 0 || (x == 0 && y==0)){
            return true;
        }
        return false;
    }
}