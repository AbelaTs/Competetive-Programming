//https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int[] minLengthArray = new int[arr.length];
        Arrays.fill(minLengthArray, Integer.MAX_VALUE);
        int minSumLength = Integer.MAX_VALUE;
        int sumHolder = 0;
        int left = 0;
        int right = 0;
        sumHolder += arr[0];
        while(right <  arr.length){
            if(sumHolder == target){
                if(right == 0){
                    minLengthArray[right] = right - left + 1;
                }else{
                    if(left - 1 >= 0 && minLengthArray[left - 1] != Integer.MAX_VALUE){
                        minSumLength = Math.min(minSumLength, minLengthArray[left-1] + right - left + 1);
                    }
                    minLengthArray[right] = Math.min(minLengthArray[right-1],right - left + 1);
                }
                right++;
                if(right < arr.length){
                    sumHolder += arr[right];
                }
            }else if(sumHolder >  target){
                if(left - 1 >= 0){
                    minLengthArray[left] = Math.min(minLengthArray[left-1],minLengthArray[left]);
                }
                sumHolder -= arr[left];
                left++;
                if(left > right){
                    right = left;
                    if(right < arr.length){
                        sumHolder += arr[right];
                    }
                }
            }else{
                right++;
                if(right < arr.length){
                    sumHolder += arr[right];
                }
            }
        }
        if(minSumLength == Integer.MAX_VALUE){
            return -1;
        }
        return minSumLength;
    }
}