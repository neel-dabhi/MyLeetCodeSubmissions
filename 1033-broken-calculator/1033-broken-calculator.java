// TC: O(log n)
// SC: O(1)
class Solution {
    public int brokenCalc(int startValue, int target) {

        int result = 0;

        while (startValue < target) {
            if (target % 2 == 0) {
                target = target / 2;
            } else {
                target = target + 1;
            }
            result++;
        }

        return result + startValue - target;

    }
}