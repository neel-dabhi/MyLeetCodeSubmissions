class Solution {
    public int smallestNumber(int n) {
        int pow = 1;
        int val = 0;
        while (val < n) {
            val = (int) Math.pow(2, pow) - 1;
            pow++;
        }

        return val;
    }
}