//https://leetcode.com/problems/integer-break/
import java.util.HashMap;

class IntegerBreak {
    public int integerBreak(int n) {
      HashMap<Integer,Integer> mapper = new HashMap<Integer,Integer>();
      return getProd(n,mapper);
    }
    public int getProd(int n,HashMap<Integer,Integer> dictionary){
        if(dictionary.containsKey(n)){
            //System.out.println(n);
           return dictionary.get(n);
        }
        if(n == 1){
            return 1;
        }
        //System.out.println(n);
       int product = 1;
       for(int i = 1; i < n; i++){
            int prod = i * Math.max(n-i,getProd(n-i,dictionary)); 
            if(prod > product){
                product = prod;
            }
       }
       dictionary.put(n,product);
       return product;
    }
}