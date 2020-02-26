//https://leetcode.com/problems/longest-palindromic-subsequence/
import java.util.HashMap;

class LongestPalindromeSebseq {
    public int longestPalindromeSubseq(String s) {
        HashMap<String,Integer> mapper = new HashMap<String,Integer>();
        return checkPalindrome(s,0,s.length()-1,mapper);
    }
    public int checkPalindrome(String word,int left,int right,HashMap<String,Integer> mapper){
        //System.out.println(left + " : " + right);
        if(left > right){
            return 0;
        }
        if(left == right){
            return 1;
        }
        if(!mapper.containsKey(left+","+right)){
            if(word.charAt(left) == word.charAt(right)){
                mapper.put(left+","+right,checkPalindrome(word,left+1,right-1,mapper)+2);

            }else{
                mapper.put(left+","+right, Math.max( checkPalindrome(word,left+1,right,mapper),checkPalindrome(word,left,right-1,mapper)));
            }
        }
        //System.out.println(left+" "+right + " : " +mapper.get(left+""+right));
        return mapper.get(left+","+right);
        
    }
}