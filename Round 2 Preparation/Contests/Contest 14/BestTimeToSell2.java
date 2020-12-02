//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buyMinimum = prices[0];
        int sellMaximum = prices[0];
        
        for(int index = 1; index < prices.length; index++){
            if( sellMaximum - buyMinimum > fee && sellMaximum - prices[index] > fee){
                profit += sellMaximum - buyMinimum - fee;
                buyMinimum = prices[index];
                sellMaximum = prices[index];
            }else if(prices[index] > sellMaximum){
                sellMaximum = prices[index];
            }else if(prices[index] < buyMinimum){
                buyMinimum = prices[index];
                sellMaximum = prices[index];
            }
        }
        
        if(sellMaximum - buyMinimum - fee > 0){
             profit += sellMaximum - buyMinimum - fee;
        }
        
        
        return profit;
    }
}