class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] dp = new int[energy.length];

        int max = Integer.MIN_VALUE;

        for (int i = dp.length - 1; i >= 0; i--) {

            int additional = 0;

            if (i + k < dp.length) {
                additional = dp[i + k];
            }

            dp[i] = energy[i] + additional;

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}