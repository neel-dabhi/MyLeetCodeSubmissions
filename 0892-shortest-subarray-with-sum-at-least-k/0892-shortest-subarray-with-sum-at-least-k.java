class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int result = Integer.MAX_VALUE;
        long runningSum = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        for (int i = 0; i < nums.length; i++) {
            runningSum = runningSum + nums[i];

            if (runningSum >= k) {
                result = Math.min(result, i + 1);
            }

            while (!pq.isEmpty() && runningSum - pq.peek()[0] >= k) {
                result = Math.min(result, i - (int) pq.poll()[1]);
            }

            pq.add(new long[] { runningSum, i });
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }
}