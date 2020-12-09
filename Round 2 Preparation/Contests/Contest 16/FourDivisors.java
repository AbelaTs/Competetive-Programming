//https://leetcode.com/problems/four-divisors/
class Solution {
    public int sumFourDivisors(int[] nums) {
        int summation = 0;
        for(int index = 0; index < nums.length; index++){
            ArrayList<Integer> primes = countPrimes(nums[index]);
            if(primes.size() == 4){
                summation += primes.get(0);
                summation += primes.get(1);
                summation += primes.get(2);
                summation += primes.get(3);
            }
        }
        return summation;
        
    }
    public ArrayList<Integer> countPrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        int limit = (int) Math.ceil(Math.sqrt(n));
        primes.add(1);
        primes.add(n);
        
        for(int index = 2; index*index <= n; index++){
            if(n % index == 0){
                if(n/index == index){
                    //returning empty if it is a perfect square
                    return new ArrayList();
                }else{
                    primes.add(index);
                    primes.add(n/index);
                }
                
            }
        }
        return primes;
        
    }
}