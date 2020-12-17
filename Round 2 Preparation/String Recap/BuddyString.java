//https://leetcode.com/problems/buddy-strings/
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(B.length() != A.length()){
            return false;
        }
        ArrayList<Integer> count = new ArrayList<>();
        for(int index = 0; index < B.length(); index++){
            if(A.charAt(index) != B.charAt(index)){
                count.add(index);
            }
        }
        if(count.size() != 2){
            if(count.size() == 0){
                HashSet<Character> unique = new HashSet<>();
                for(int index = 0; index < B.length(); index++){
                    unique.add(B.charAt(index));
                }
                if(unique.size() < B.length()){
                    return true;
                }
            }
            return false;
        }else{
            char[] chars = B.toCharArray();
            char temp = chars[count.get(0)];
            chars[count.get(0)] = chars[count.get(1)];
            chars[count.get(1)] = temp;
            for(int index = 0; index < chars.length; index++){
                if(A.charAt(index) != chars[index]){
                    return false;
                }
            }
        }
        
        return true;
        
    }
    public boolean checkPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}