class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lastBought = -1;
        
        for(int i=1; i< prices.length; i++){

            if(prices[i-1] < prices[i]){
                // increasing
                maxProfit = maxProfit + ( prices[i]- prices[i-1] );
            }
        }

        return maxProfit;
    }
}