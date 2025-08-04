class Solution {
    public int shortestPath(int[][] grid, int k) {
        int steps = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> bfs = new LinkedList<>();

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        bfs.add(new int[] { 0, 0, k });
        visited[0][0][k] = true;

        if (k >= m + n - 2){
            return m + n - 2;
        }
        
        while (!bfs.isEmpty()) {

            int size = bfs.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = bfs.poll();
                int r = curr[0];
                int c = curr[1];
                int currK = curr[2];

                if (r == m - 1 && c == n - 1) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int x = r + dir[0];
                    int y = c + dir[1];

                    if (x >= 0 && y >= 0 && y < n && x < m) {
                        int temp = currK - grid[r][c];
                        if (temp >=0 && !visited[x][y][temp]) {
                            bfs.add(new int[] { x, y, temp });
                            visited[x][y][temp] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

}