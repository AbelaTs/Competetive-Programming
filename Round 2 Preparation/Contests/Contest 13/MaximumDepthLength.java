//https://leetcode.com/contest/weekly-contest-144/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int aCount = 0;
        int bCount = 0;
        for(int index = 0; index < seq.length(); index++){
            if(seq.charAt(index) == '('){
                if(aCount <= bCount){
                    result[index] = 0;
                    aCount++;
                }else{
                    result[index] = 1;
                    bCount++;
                }
            }else{
                if(aCount >= bCount){
                    result[index] = 0;
                    aCount--;
                }else{
                    result[index] = 1;
                    bCount--;
                }
            }
        }
        return result;
        
    }
}