//https://leetcode.com/contest/leetcode-weekly-contest-55/problems/subarray-product-less-than-k/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int subArrayCount = 0;
        int product = 1;
        int left = 0;
        int right = 0;
        while(right <  nums.length && left < nums.length){
            if(nums[right] * product < k){
                subArrayCount += right - left +1;
                product *= nums[right];
                right++;
            }else{
                product /= nums[left];
                left++;
                if(left > right){
                    right = left;
                    product = 1;
                }
                
            }
        }
        return subArrayCount;
        
    }
}