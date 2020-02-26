//https://leetcode.com/problems/product-of-the-last-k-numbers/
import java.util.ArrayList;

class ProductLastK {
    ArrayList<Integer> numlist;
    int last_zero_index = -1;
    public ProductLastK() {
        numlist = new ArrayList<Integer>();
    }
    
    public void add(int num) {
        if(numlist.size() > 0){
            if(numlist.get(numlist.size()-1) == 0){
                last_zero_index = numlist.size()-1;
                numlist.add(num);
            }else{
                numlist.add(num * numlist.get(numlist.size()-1));
            }
            
        }else{
            numlist.add(num);
        }
    }
    
    public int getProduct(int k) {
        int product = 1;
        if(numlist.size() - (k+1) > last_zero_index){
            //System.out.println(numlist.get(numlist.size()-1) +  " : " + numlist.get(numlist.size() - (k+1)));
            product = numlist.get(numlist.size()-1)/numlist.get(numlist.size() - (k+1));
        }else if(numlist.size() - (k+1) == last_zero_index){
            product = numlist.get(numlist.size()-1);
            
        }else{
            product = 0;
        }
        
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */