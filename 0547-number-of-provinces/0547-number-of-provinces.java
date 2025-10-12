class Solution {
    int provinces;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        provinces = 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                bfs(i, isConnected, set);
                set.add(i);
                provinces++;
            }

        }

        return provinces;
    }

    private void bfs(int i, int[][] isConnected, Set<Integer> set) {

        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(i);

        while (!bfs.isEmpty()) {

            int city = bfs.poll();

            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[city][j] == 1 && !set.contains(j)) {
                    set.add(j);
                    bfs.add(j);
                }
            }
        }
    }
}