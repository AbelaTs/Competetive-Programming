//https://leetcode.com/problems/longest-happy-prefix/
class Solution {
    public String longestPrefix(String s) {
        int[] preSuffixTable = new int[s.length()];
        int left = 0;
        int right = left+1;
        while(right < s.length()){
            if(s.charAt(right) == s.charAt(left)){
                preSuffixTable[right] = left+1;
                left++;
                right++;
            }else{
                if(left == 0){
                    preSuffixTable[right] = 0;
                    right++;
                }else{
                    left = preSuffixTable[left-1]; 
                }
            }
            
        }
        StringBuilder result = new StringBuilder();
        for(int index = 0; index < preSuffixTable[preSuffixTable.length -1]; index++){
            result.append(s.charAt(index));
        }
        
        return result.toString();
        
    }
}