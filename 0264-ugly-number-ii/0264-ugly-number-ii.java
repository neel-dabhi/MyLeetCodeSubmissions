// TC: O(n)
// SC: O(1)
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {

            int min = Math.min(n5, Math.min(n2, n3));
            dp[i] = min;
            
            if (min == n5) {
                p5++;
                n5 = dp[p5] * 5;
            }
            if (min == n3) {
                p3++;
                n3 = dp[p3] * 3;
            }
            if (min == n2) {
                p2++;
                n2 = dp[p2] * 2;
            }

            
        }
        return dp[n - 1];
    }
}