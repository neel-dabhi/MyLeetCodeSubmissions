class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high = high + nums[i];
        }

        while (low <= high) {
            int sum = low + (high - low) / 2;

            if (canSplit(nums, sum, k)) {
                high = sum - 1;
            } else {
                low = sum + 1;
            }
        }
        return low;
    }

    private boolean canSplit(int[] nums, int sum, int k) {
        int total = 0;
        int count = 1;

        for (int i = 0; i < nums.length; i++) {

            if (total + nums[i] > sum) {
                count++;
                total = nums[i];
            } else {
                total += nums[i];
            }
        }

        return count <= k;
    }
}