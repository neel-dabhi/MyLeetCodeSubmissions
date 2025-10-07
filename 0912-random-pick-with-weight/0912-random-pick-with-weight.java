class Solution {
    int sum = 0;
    int[] prefixSum;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        for (int i = 0; i < prefixSum.length; i++) {
            sum = sum + w[i];
            prefixSum[i] = sum;
        }
    }

    public int pickIndex() {
        int rand = (int) (Math.random() * sum);
        return binarySearch(rand);
    }

    private int binarySearch(int target) {
        int low = 0;
        int high = prefixSum.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target < prefixSum[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */