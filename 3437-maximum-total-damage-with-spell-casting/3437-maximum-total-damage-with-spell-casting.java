class Solution {
    int maxDamage = Integer.MIN_VALUE;

    public long maximumTotalDamage(int[] power) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        int n = map.size();
        long[] vals = new long[n];
        long[] earns = new long[n];

        int i = 0;
        for (int key : new TreeSet<>(map.keySet())) {
            vals[i] = key;
            earns[i] = (long) key * map.get(key);
            i++;
        }

        // Binary Search
        int[] nextIndex = new int[n];
        for (int j = 0; j < n; j++) {
            int low = 0;
            int high = n;

            long target = vals[j] + 3;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (vals[mid] >= target) {
                    high = mid;
                } else if (vals[mid] < target) {
                    low = mid + 1;
                }
            }
            nextIndex[j] = low;
        }

        long[] memo = new long[n + 1];
        Arrays.fill(memo, Long.MIN_VALUE);

        return helper(0, vals, earns, nextIndex, memo);
    }

    private long helper(int index, long[] vals, long[] earns, int[] nextIndex, long[] memo) {

        if (index == vals.length) {
            return 0l;
        }

        if (memo[index] != Long.MIN_VALUE) {
            return memo[index];
        }

        // Skip
        long skip = helper(index + 1, vals, earns, nextIndex, memo);

        // Choose
        long choose = earns[index] + helper(nextIndex[index], vals, earns, nextIndex, memo);

        memo[index] = Math.max(choose, skip);
        return memo[index];
    }

}