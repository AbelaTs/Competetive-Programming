class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        for(int index = 0; index < nums.length; index++){
            if(nums[index] >= target){
                return index;
            }
        }
        return nums.length;
    }
}