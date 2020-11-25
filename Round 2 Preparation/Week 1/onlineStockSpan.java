//https://leetcode.com/problems/online-stock-span/
class StockSpanner {
    ArrayList<Integer> stockList;

    public StockSpanner() {
        stockList = new ArrayList<>();
    }
    
    public int next(int price) {        
        int counter = 0;
         stockList.add(price);
        for(int index = stockList.size()-1; index >= 0; index--){
            if(stockList.get(index) <= price){
                counter++;
            }else if(stockList.get(index) > price){
                break;
            }
        }
        return counter;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */