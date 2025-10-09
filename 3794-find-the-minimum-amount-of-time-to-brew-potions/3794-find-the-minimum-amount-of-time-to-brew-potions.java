class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long[] finishTimes = new long[n];

        for (int i = 0; i < m; i++) {
            long time = 0; // prefix sum of times
            for (int j = 0; j < n; j++) {
                time = Math.max(time, finishTimes[j]) + (long)skill[j] * mana[i];
            }

            finishTimes[n - 1] = time;

            // correction loop
            for (int j = n - 2; j >= 0; j--) {
                finishTimes[j] = finishTimes[j + 1] - (long) skill[j +1] * mana[i];
            }

        }
        return finishTimes[n-1];
    }
}