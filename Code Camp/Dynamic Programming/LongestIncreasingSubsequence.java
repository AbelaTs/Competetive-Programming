//https://leetcode.com/problems/number-of-longest-increasing-subsequence/
import java.util.HashMap;

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
       int max_seq = 0;
       if(nums.length == 1){
           return 1;
       }
       HashMap<Integer,Integer> mapper = new HashMap<Integer,Integer>();
       mapper.put(nums.length - 1,1);
        if(nums.length >= 2){
           for(int i = nums.length-2; i >= 0; i--){
                int max_count = 0;//counts the number of items that are greater than it
                for(int j = nums.length -1; j > i; j--){
                    if(nums[j] > nums[i]){
                        if(mapper.get(j) > max_count){
                            max_count = mapper.get(j);
                        }
                    }
                }
                mapper.put(i,max_count+1);
                if(max_count+1 > max_seq){
                    max_seq = max_count+1;
                }
            }
        }
        
        return max_seq;
    }
    
}