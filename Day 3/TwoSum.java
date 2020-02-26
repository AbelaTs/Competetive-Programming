//https://leetcode.com/problems/two-sum
public class TwoSum {
   
        public static int[] twoSum(int[] nums, int target) {
                for(int i =0; i < nums.length;i++){
                for(int j=0;j < nums.length;j++){
                    if(nums[i]+nums[j]==target){
                        int[] answer = {i,j};
                        return answer;
                    }
                }
            }
            return null;
            }
  
}