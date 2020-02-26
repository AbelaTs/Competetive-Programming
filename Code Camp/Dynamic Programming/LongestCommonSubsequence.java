//https://leetcode.com/problems/longest-common-subsequence/
import java.util.HashMap;

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        HashMap<String,Integer> mapper = new HashMap<String,Integer>();
        return getLongestSebsequence(text1,text2,text1.length()-1,text2.length()-1,mapper);
    }
    public int getLongestSebsequence(String str, String str2,int index1,int index2,HashMap<String,Integer> dictionary){
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        if(!dictionary.containsKey(index1 +","+ index2)){
            if(str.charAt(index1) == str2.charAt(index2)){
                dictionary.put(index1 +","+ index2, getLongestSebsequence(str,str2,index1 - 1,index2 -1,dictionary)+1);
            }else{
                dictionary.put(index1 +","+ index2, Math.max(getLongestSebsequence(str,str2,index1 - 1,index2,dictionary),getLongestSebsequence(str,str2,index1,index2 -1,dictionary)));
            }
        }
        return dictionary.get(index1 +","+ index2);
    }
}