class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n = spells.length;
        int[] result = new int[n];

        Arrays.sort(potions); // (n log n)

        for (int i = 0; i < n; i++) {
            int spell = spells[i];

            int idx = binarySearch(potions, spell, success);

            result[i] = potions.length - idx;
        }

        return result;
    }

    private int binarySearch(int[] potions, int spell, long success) {

        int low = 0;
        int high = potions.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((long) potions[mid] * (long) spell >= success) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}