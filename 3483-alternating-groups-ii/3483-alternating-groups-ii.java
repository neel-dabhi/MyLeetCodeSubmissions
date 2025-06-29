class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int N = colors.length;
        int left = 0;
        int result = 0;
        for (int i = 1; i < N + k - 1; i++) {
            if (colors[i % N] == colors[(i - 1) % N]) {
                left = i;
            }
            if (i - left + 1 > k) {
                left++;
            }
            if (i - left + 1 == k) {
                result++;
            }

        }
        return result;
    }
}