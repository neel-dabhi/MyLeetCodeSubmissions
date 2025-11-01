class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int v = Math.abs(nums[i]);

            if (v == n) {
                v = 0;
            }

            if (nums[v] >= 0) {
                if (nums[v] == 0) {
                    nums[v] = -n;
                } else {
                    nums[v] = -nums[v];
                }
            } else {
                result[idx] = v;
                idx++;
            }
        }
        return result;
    }
}