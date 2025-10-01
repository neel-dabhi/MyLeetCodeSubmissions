class Solution {
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);

            if (val >= 1 && val <= nums.length) {
                int index = val - 1;

                if (nums[index] > 0) {
                    nums[index] = -nums[index];
                } else if (nums[index] == 0) {
                    nums[index] = -(nums.length + 1);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}