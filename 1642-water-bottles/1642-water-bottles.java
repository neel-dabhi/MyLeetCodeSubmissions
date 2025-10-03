class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = 0;

        while (numBottles >= numExchange) {
            result = result + numExchange;
            numBottles = numBottles - numExchange + 1;
        }

        return numBottles + result;
    }
}