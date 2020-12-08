//https://leetcode.com/problems/broken-calculator/
class Solution {
    public int brokenCalc(int X, int Y) {
        int counter = 0;
        while(X != Y){
            if(X > Y){
                counter += X-Y;
                break;
            }else if(Y % 2 == 0){
                Y /= 2;
            }else if(Y % 2 != 0){
                Y++;
            }
            counter++;
        }
        return counter;
    }
}