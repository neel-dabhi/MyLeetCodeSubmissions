
class Solution {
    public int maxProfit(int[] prices) {
        int currMin = Integer.MAX_VALUE;
        int result = 0;
        for(int price: prices){
            currMin = Math.min(currMin, price);
            result = Math.max(price - currMin, result);
        }
        return result;
    }
}