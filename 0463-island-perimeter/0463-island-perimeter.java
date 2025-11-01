class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> bfs = new LinkedList<>();

        // prime the queue with first land block
        outer: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int[] landBlock = new int[] { i, j };
                    bfs.add(landBlock);
                    visited[i][j] = true;
                    break outer;
                }
            }
        }

        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();

            int land = 0;

            for (int[] dir : dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];

                if (row >= 0 && row < n && col >= 0 && col < m &&
                        grid[row][col] == 1) {

                    if (visited[row][col]) {
                        land++;
                        continue;
                    }
                    int[] landBlock = new int[] { row, col };
                    bfs.add(landBlock);
                    visited[row][col] = true;
                    land++;
                }
            }
            perimeter = perimeter + (4 - land);
        }
        return perimeter;
    }
}