class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);

        Set<Integer> visited = new HashSet<>();
        int time = 0;

        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        pq.add(new int[] { 0, 0 });
        visited.add(grid[0][0]);

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];

            time = Math.max(time, grid[x][y]);

            if (x == n - 1 && y == n - 1) {
                return time;
            }

            for (int[] dir : dirs) {
                int row = x + dir[0];
                int col = y + dir[1];

                if (row >= 0 && row < n && col >= 0 && col < n
                        && !visited.contains(grid[row][col])) {
                    pq.add(new int[] { row, col });
                    visited.add(grid[row][col]);
                }
            }
        }
        return -1;
    }
}