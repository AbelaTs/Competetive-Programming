//https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int l = nums.length;
        
        int maxsofar = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        
        int runningSum1 = 0;
        int runningSum2 = 0;
        
        for(int i = 0; i < l ; i++){
            runningSum1 += nums[i];
            runningSum2 += nums[i];
            
            if(runningSum1 > maxsofar)
                maxsofar = runningSum1;
            if(runningSum1 < 0)
                runningSum1 = 0;
            
            if(runningSum2 < minSoFar)
                minSoFar = runningSum2;
            if(runningSum2 > 0)
                runningSum2 = 0;
        }
        
        return Math.max(Math.abs(maxsofar),Math.abs(minSoFar));
    }
}
