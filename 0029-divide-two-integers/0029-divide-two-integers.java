// TC :O(log n)
// SC: O(1)
class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        while(dvd >= dvs){
            long current = dvs;
            int numShifts = 0;

            while((current << 1) <= dvd){
                numShifts++;
                current = current << 1;
            }

            result += 1 << numShifts;
            dvd = dvd - current;
        }

        if(negative) return -result;
        return result;
    }
}