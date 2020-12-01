//https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right  = nums.length -1;
        while(left <= right){
            int middle = left + ((right - left)/2);
            //System.out.println(nums[middle]);
            if(nums[left] <= nums[middle]){
               if(nums[middle] == target){
                   return middle;
               }else if(target <= nums[middle] && target >= nums[left]){
                   right = middle -1;
               }else{
                   left = middle+1;
               }
            }else{
                //System.out.println(nums[left] + ","+ nums[middle]);
                if(target == nums[middle]){
                    return middle;
                }else if(target == nums[left]){
                    return left;
                }else if(target > nums[left] || target < nums[middle]){
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }
        }
        return -1;
        
    }
}
