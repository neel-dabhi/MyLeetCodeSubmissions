class Solution {
    int result = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] memo = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 0; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(strs, 0, m, n, memo);
    }

    private int dfs(String[] strs, int idx, int zeros, int ones, int[][][] memo) {
        if (idx == strs.length) {
            return 0;
        }

        if (memo[idx][zeros][ones] != -1) {
            return memo[idx][zeros][ones];
        }

        String curr = strs[idx];
        int[] counts = getCount(curr);
        int choose = 0;
        if (zeros >= counts[0] && ones >= counts[1]) {
            // choose
            choose = 1 + dfs(strs, idx + 1, zeros - counts[0], ones - counts[1], memo);
        }

        // not choose
        int notChoose = dfs(strs, idx + 1, zeros, ones, memo);

        memo[idx][zeros][ones] = Math.max(choose, notChoose);

        return memo[idx][zeros][ones];
    }

    private int[] getCount(String str) {
        int ones = 0;
        int zeros = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                ones++;
            } else {
                zeros++;
            }
        }

        return new int[] { zeros, ones };
    }
}