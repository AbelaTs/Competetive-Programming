//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
import java.util.ArrayList;
import java.util.HashMap;

class BestTimeToSell {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        HashMap<Integer,ArrayList<Integer>> mapper = new HashMap<Integer,ArrayList<Integer>>();
        int profit = 0;
        int start = 0;
        mapper.put(start,new ArrayList<Integer>());
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < prices[start]){
                start = i;
                mapper.put(start,new ArrayList<Integer>());
            }else{
                //if it current price is lesser than yesterday
                if(prices[i] < prices[i - 1]){
                    //sell the previous item and buy a new one
                    start = i;
                    mapper.put(start,new ArrayList<Integer>());
                }else if(prices[i] > prices[start]){// if it gets good price
                    mapper.get(start).add(i);
                }
            }
        }
        //calculating the profit of each stock
        for(Integer stock_value : mapper.keySet()){
            ArrayList<Integer> possible_stocks = mapper.get(stock_value);
            int temp_profit = 0;
            for(int i = 0; i < possible_stocks.size(); i++){
                //calculating profit
                int diff = prices[possible_stocks.get(i)] - prices[(int)stock_value];
                if(diff > temp_profit){
                    temp_profit = diff;
                }
            }
            profit += temp_profit;
        }
        return profit;
    }
}