class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        Arrays.sort(nums);

        int low = 1;
        int high = nums[n - 1];

        int answer = high;
        while (low <= high) {
            int divisor = low + (high - low) / 2;

            if (getSum(nums, divisor, threshold) <= threshold) {
                answer = divisor;
                high = divisor - 1;
            } else {
                low = divisor + 1;
            }
        }

        return answer;

    }

    private int getSum(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int i : nums) {
            sum = sum + ((i + divisor - 1) / divisor);
            if (sum > threshold){
                return sum;
            }
        }
        return sum;
    }
}