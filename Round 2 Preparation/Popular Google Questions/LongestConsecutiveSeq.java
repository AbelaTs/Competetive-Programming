//https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numList = new HashSet<>();
        int maxNum = 0;
        for(int index = 0; index < nums.length; index++){
            numList.add(nums[index]);
        }
        int counter = 0;
        for(int index = 0; index < nums.length; index++){
            if(!numList.contains(nums[index]-1)){
                int tempCounter = 1;
                int numCounter = nums[index]+1;
                while(numList.contains(numCounter)){
                    tempCounter++;
                    numCounter++;
                }
                counter = Math.max(tempCounter,counter);
            }
        }
        return counter;
    }
}