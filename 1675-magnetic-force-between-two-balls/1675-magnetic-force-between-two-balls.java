class Solution {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position); // n log n
        int ans = 0;
        int low = 1;
        int high = position[position.length - 1] - position[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (helper(position, mid, m)) {
                // valid dist 
                // check for next bigger
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }

        }
        return ans;
    }

    public boolean helper(int[] position, int dist, int balls) {
        int count = 1;
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= dist) {
                count++;
                last = position[i];
                if (count >= balls) {
                    return true;
                }
            }
        }
        return false;
    }
}