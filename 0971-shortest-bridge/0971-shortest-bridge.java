// TC: O(nxm)
// SC: O(nxm)
class Solution {
    public int shortestBridge(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> bfs = new LinkedList<>();
        Queue<int[]> explore = new LinkedList<>();

        boolean flag = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (flag && grid[i][j] == 1) {
                    explore.add(new int[] { i, j });
                    bfs.add(new int[] { i, j });
                    grid[i][j] = -1;
                    flag = false;
                }
            }
        }

        while (!explore.isEmpty()) {
            int[] curr = explore.poll();

            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x >= 0 && y >= 0 && x < rows && y < rows && grid[x][y] == 1) {
                    explore.add(new int[] { x, y });
                    bfs.add(new int[] { x, y });
                    grid[x][y] = -1;
                }
            }

        }

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                int[] curr = bfs.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newY >= 0 && newX < rows && newY < cols) {
                        if (grid[newX][newY] == 1) {
                            return result;
                        } else if (grid[newX][newY] == 0) {
                            bfs.add(new int[] { newX, newY });
                            grid[newX][newY] = -1;
                        }
                    }
                }
            }
            result++;

        }

        return result;

    }
}