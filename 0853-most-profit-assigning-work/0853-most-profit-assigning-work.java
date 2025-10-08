class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        int[][] sorted = new int[n][2];

        for (int i = 0; i < n; i++) {
            sorted[i] = new int[] { difficulty[i], profit[i] };
        }

        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < n; i++) {
            sorted[i][1] = Math.max(sorted[i][1], sorted[i - 1][1]);
        }

        int netProfit = 0;
        for (int w : worker) {
            int idx = binarySearch(sorted, w);

            if (idx < 0) {
                netProfit = netProfit + 0;
            } else {
                netProfit = netProfit + sorted[idx][1];
            }

        }

        return netProfit;
    }

    private int binarySearch(int[][] sorted, int workerCapacity) {

        int low = 0;
        int high = sorted.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (sorted[mid][0] <= workerCapacity) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}