class Solution {
    public int minOperations(int[] nums) {
        int[] multipleMax = new int[]{0};
        int result = 0;
        for(int num :  nums){
            result += calculate(num,multipleMax);
        }
        result += multipleMax[0];
        return result;
        
    }
    public int calculate(int num, int[] max){
        int evenCounter = 0;
        int counter = 0;
        while(num > 0){
            if(num % 2 == 0){
                evenCounter++;
                if(max[0] < evenCounter){
                    max[0] = evenCounter;
                }
                num /= 2;
            }else{
                num--;
                counter++;
            }
        }
        return counter;        
    }
}