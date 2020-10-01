//https://leetcode.com/problems/largest-number/
class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
           public int compare(Integer lhs,Integer rhs){
               String leftNum = Integer.toString(lhs);
               String rightNum = Integer.toString(rhs);
               if(leftNum.length() == rightNum.length()){
                   for(int index = 0; index < leftNum.length(); index++){
                       if(Integer.parseInt(String.valueOf(leftNum.charAt(index))) == Integer.parseInt(String.valueOf(rightNum.charAt(index)))){
                           
                           continue;
                       }else if(Integer.parseInt(String.valueOf(leftNum.charAt(index))) < Integer.parseInt(String.valueOf(rightNum.charAt(index)))){
                           return 1;
                       }else{
                           return -1;
                       }
                   }
               }else{
                   if(Integer.parseInt(leftNum+rightNum) > Integer.parseInt(rightNum+leftNum)){
                       return -1;
                   }else if(Integer.parseInt(leftNum+rightNum) < Integer.parseInt(rightNum+leftNum)){
                       return 1;
                   }
               }
               return 0;
              
           } 
        });
        for(int index = 0; index < nums.length; index++){
           maxHeap.add(nums[index]);    
        }
        String result = "";
        while(!maxHeap.isEmpty()){
            result += Integer.toString(maxHeap.poll());
        }
        for(int index = 0; index < result.length(); index++){
            if(result.charAt(index) != '0'){
                return result;
            }
        }
       
        return "0";
    }