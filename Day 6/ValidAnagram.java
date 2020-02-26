//https://leetcode.com/problems/valid-anagram/
import java.io.*; 
import java.util.*; 
class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        
        ArrayList<Character> string1 = new ArrayList<Character>();
        for(int j=0; j<s.length();j++){
           string1.add(s.charAt(j));
        }
        if(s.length() == t.length()){
        for(int i=0; i<t.length(); i++){
                if(string1.contains(t.charAt(i))){
                    int index = string1.indexOf(t.charAt(i));
                    string1.remove(index);
                }
            
        }
        if(string1.size() == 0){
            return true;
        }
        return false;
    }
    return false;
    }
    public static void main(String args[]){
        System.out.println(isAnagram("aacc","ccac"));
    }
}