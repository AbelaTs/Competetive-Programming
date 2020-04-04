import java.util.Arrays;

public class SumClosest3 {
    public int getSumClosest(int[] nums,int target){
        Arrays.sort(nums);
        int minSum = 0;
        int minDifference = Integer.MAX_VALUE;
        for(int index = 0; index < nums.length; index++){
            int left = 0; 
            int right = nums.length-1;
            while(left  < right){
                if(left == index){
                    left++;
                    continue;
                }else if(right == index){
                    right--;
                    continue;
                }
                if(nums[left] + nums[right] + nums[index] == target){
                    return target;
                }else if(nums[left] + nums[right] + nums[index] < target){
                    if(Math.abs(nums[left] + nums[right] + nums[index] - target) < minDifference){
                        minDifference = Math.abs(nums[left] + nums[right] + nums[index] - target);
                        minSum = nums[left] + nums[right] + nums[index];
                    }
                    left++;
                }else{
                    if(Math.abs(nums[left] + nums[right] + nums[index] - target) < minDifference){
                        minDifference = Math.abs(nums[left] + nums[right] + nums[index] - target);
                        minSum = nums[left] + nums[right] + nums[index];
                    }
                    right--;
                }
            }
        }
        return minSum;
    }
}