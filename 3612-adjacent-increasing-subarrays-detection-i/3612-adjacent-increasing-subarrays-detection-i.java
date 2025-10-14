class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        boolean[] arr = new boolean[n];

        if (k == 1) {
            return true;
        }

        int size = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) < nums.get(i + 1)) {
                size = size + 1;
                if (size >= k - 1) {
                    arr[i - k + 2] = true;
                }
            } else {
                size = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == true && i + k < n && arr[i + k] == true) {
                return true;
            }
        }

        return false;
    }
}