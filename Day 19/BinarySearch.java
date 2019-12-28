class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left <= right){
            mid = left+((right - left)/2);//to prevent overflow
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }
}