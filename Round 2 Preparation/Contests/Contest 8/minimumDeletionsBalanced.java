//https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/submissions/
class Solution {
    public int minimumDeletions(String s) {
        int[] aCount = new int[s.length()];
        int[] bCount = new int[s.length()];
        int minimumCount = Integer.MAX_VALUE;
        //populating for a count
        for(int index = s.length()-1; index >= 0; index--){
            if(s.charAt(index) == 'a'){
                if(index == s.length()-1){
                    aCount[index] = 1;
                }else{
                    aCount[index] = aCount[index+1]+1;
                }
            }else{
                if(index == s.length()-1){
                    aCount[index] = 0;
                }else{
                    aCount[index] = aCount[index+1];
                }
                
            }
        }
        //populating for b count
        for(int index = 0; index <  s.length(); index++){
            if(s.charAt(index) == 'b'){
                if(index == 0){
                    bCount[index] = 1;
                }else{
                    bCount[index] = bCount[index-1]+1;
                }
            }else{
                 if(index == 0){
                     bCount[index] = 0;
                 }else{
                    bCount[index] = bCount[index-1];
                 }
            }
        }
        //populating the minimumCount
        for(int index = 0; index <  s.length(); index++){
            if(s.charAt(index) == 'a'){
               minimumCount = Math.min(minimumCount,(aCount[index]-1) + bCount[index]);
                
            }else{
               minimumCount = Math.min(minimumCount,aCount[index] + bCount[index]);
            }
        }
        minimumCount = Math.min(minimumCount, aCount[0]);
        minimumCount = Math.min(minimumCount, bCount[bCount.length - 1]);
        return minimumCount;
        
    }
}