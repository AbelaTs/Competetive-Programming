//https://leetcode.com/problems/check-if-a-string-can-break-another-string/
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s1Chars = new char[s1.length()];
        char[] s2Chars = new char[s2.length()];
        for(int index = 0; index < s1.length(); index++){
            s1Chars[index] = s1.charAt(index);
        }
        for(int index = 0; index < s1.length(); index++){
            s2Chars[index] = s2.charAt(index);
        }
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        boolean s1ShouldBreak = false;
        boolean equalSofar = true;
        boolean checkFirst = true;
        for(int index = 0; index < s1Chars.length; index++){
            if(checkFirst){
                if(s1Chars[index] > s2Chars[index]){
                    s1ShouldBreak = true;
                    checkFirst = false;
                }else if(s1Chars[index] < s2Chars[index]){
                    checkFirst = false;
                }
            }else{
                if(s1ShouldBreak){
                    if(s1Chars[index] < s2Chars[index]){
                        return false;
                    }
                }else{
                    if(s2Chars[index] < s1Chars[index]){
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}