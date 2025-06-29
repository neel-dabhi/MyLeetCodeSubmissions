class Solution {
    public int mySqrt(int x) {

        int low = 0;
        int high = x;
        int prev = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long)mid * mid == x) {
                return mid;
            } else if ((long)mid * mid < x) {
                prev = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return prev;
    }
}