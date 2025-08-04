// TC: O(n)
// SC: O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] arr = new int[nums.length];

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                arr[i] = 1 + arr[i - 1];
            }
        }

        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }

        return sum;
    }
}