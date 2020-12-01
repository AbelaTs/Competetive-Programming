//https://leetcode.com/problems/perfect-number/
class Solution {
    public boolean checkPerfectNumber(int num) {
        int half =  num/2;
        int sum = 0;
        while(half > 0){
            if(num % half == 0){
                sum += half;
            }
            half--;
        }
        if(sum == num){
            return true;
        }
        return false;
    }
}
