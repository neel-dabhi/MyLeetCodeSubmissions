// TC: O(n log n)
// SC: O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxCapacity = 0;
        int minCapacity = Integer.MIN_VALUE;

        for (int weight : weights) {
            maxCapacity = maxCapacity + weight;
            minCapacity = Math.max(minCapacity, weight);
        }

        int low = minCapacity;
        int high = maxCapacity;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int k = 1;
            int sum = 0;
            for (int weight : weights) {
                sum = sum + weight;

                if (sum > mid) {
                    k++;
                    sum = weight;
                }
            }

            if (k <= days) {
               high = mid - 1; // try even smaller
            } else {
                // capacity is low
                low = mid + 1;
            }

        }
        return low;

    }
}