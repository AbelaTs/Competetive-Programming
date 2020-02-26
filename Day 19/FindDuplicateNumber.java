//https://leetcode.com/problems/find-the-duplicate-number/
class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        boolean foundDuplicate = false;
        int left = 0;
        int right = nums.length-1;
        int mid = left +((right - left)/2);
        int left_half = mid;
        int right_half = mid;
        //left search
        while(left < left_half){
            if(nums[left_half] == nums[left_half-1] || nums[left_half] == nums[left]){
                duplicate = nums[left_half];
                foundDuplicate = true;
                break;
            }
            
            left_half = left_half - 1;
            
        }
        //right search
        if(!foundDuplicate){
            while(right_half < right){
                if(nums[right_half] == nums[right_half+1] || nums[right_half] == nums[right]){
                    duplicate = nums[right_half];
                    foundDuplicate = true;
                    break;
                }
                right_half = right_half + 1;
            
            }
            
        }
        //Both side search 
        if(!foundDuplicate){
            while(left < mid){
                int half = mid+1;
                while(half <= right){
                    if(nums[left] ==  nums[half]){
                        foundDuplicate = true;
                        duplicate = nums[left];
                        break;
                    }
                    half = half+1;
                }
                
                if(foundDuplicate){
                    break;
                }
                left = left +1;
            }
        }
   
        return duplicate;
    }
}