//https://leetcode.com/problems/n-th-tribonacci-number/
class NthTribonacci {
    public int tribonacci(int n) {
       if(n > 2){ 
            int result = 0;
            int num1 = 0;
            int num2 = 1;
            int num3 = 1;

            for(int i = 0; i < n-2; i++){
                result = num1 + num2 + num3;
                num1 = num2;
                num2 = num3;
                num3 = result;
            }
           
            return result;
       }else{
           if(n == 2){
               return 1;
           }
           return n;
       }
    }
}