class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int fresh = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> bfs = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // get fresh count and prime the bfs queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    bfs.add(new int[] { i, j });
                }
            }
        }
        // if no fresh it all rotten at t0
        if (fresh == 0) {
            return 0;
        }

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                int[] curr = bfs.poll();

                int x = curr[0];
                int y = curr[1];

                for (int[] dir : dirs) {
                    int row = x + dir[0];
                    int col = y + dir[1];

                    // bounds check, fesh check
                    if (row >= 0 && col >= 0 && row < n && col < m && grid[row][col] == 1) {
                        bfs.add(new int[] { row, col });
                        grid[row][col] = 2;
                        fresh--;

                        if (fresh == 0) {
                            return time + 1;
                        }
                    }
                }
            }
            time++;
        }

        return -1;
    }
}