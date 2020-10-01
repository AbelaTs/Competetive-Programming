// /https://leetcode.com/problems/sqrtx/
class Solution {
    public int mySqrt(int x) {
        if(x ==0 || x == 1 ){
            return x;
        }
        int initial = 0;
        int end = x/2;
        while(initial <= end){
            int mid = (initial + end)/2;
            mid = Math.min(mid, 46341);
            double  midSquare = (double) Math.pow(mid, 2);
            double  nextMidSquare = (double) Math.pow(mid+1,2);
            if((midSquare <= x && nextMidSquare > x)){
                return mid;
            }
            if(midSquare > x){
                end = mid - 1;
            }else{
                initial = mid + 1;
            }
            
        }
        return x;
        
    }
}