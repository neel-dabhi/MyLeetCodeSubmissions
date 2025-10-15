class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {

        int low = 1;
        int high = nums.size() - 1;

        int lastValid = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValidSubarray(nums, mid)) {
                // find better/bigger
                low = mid + 1;
                lastValid = mid;
            } else {
                high = mid - 1;
            }
        }

        return lastValid;
    }

    private boolean isValidSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        boolean[] arr = new boolean[n];

        if (k == 1) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {

            if (nums.get(i) < nums.get(i + 1)) {
                count++;
                if (count >= k - 1) {
                    arr[i - k + 2] = true;
                }
            } else {
                count = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] && i + k < n && arr[i + k]) {
                return true;
            }
        }

        return false;
    }
}