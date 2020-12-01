//https://leetcode.com/problems/count-primes/
class Solution {
    public int countPrimes(int n) {
        int primeCount = 0;
        int[] numsList = new int[n];
        for(int index = 2; index < n; index++){
            numsList[index] = 1;
        }
        for(int index = 2; index*index < n; index++){
            if(numsList[index] == 1){
                int squaredValue = (int) Math.pow(index,2);
                while(squaredValue < n){
                    numsList[squaredValue] = 0;
                    squaredValue+=index;
                }
            }
        }
        
        for(int index = 0; index <  n; index++){
            if(numsList[index] == 1){
                primeCount++;
            }
        }
        return primeCount;
        
    }
}