class Solution {
    int[][][] dp;

    public int minimumDistance(String word) {
        int n = word.length();
        // n length; 26 for L finger pos and 26 for R. [i][L][R] 27th for ' '
        dp = new int[n][27][27];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 26, 26, word);
    }

    private int helper(int i, int left, int right, String word) {
        if (i == word.length()) {
            return 0;
        }
        if (dp[i][left][right] != -1) {
            return dp[i][left][right];
        }
        int curr = word.charAt(i) - 'A';
        int leftFinger = dist(curr, left) + helper(i + 1, curr, right, word);
        int rightFinger = dist(curr, right) + helper(i + 1, left, curr, word);

        dp[i][left][right] = Math.min(leftFinger, rightFinger);
        return dp[i][left][right];
    }

    private int dist(int curr, int prev) {

        if (prev == 26) {
            return 0;
        }

        int x1 = (prev - 'A') / 6;
        int x2 = (curr - 'A') / 6;
        int y1 = (prev - 'A') % 6;
        int y2 = (curr - 'A') % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);

    }
}