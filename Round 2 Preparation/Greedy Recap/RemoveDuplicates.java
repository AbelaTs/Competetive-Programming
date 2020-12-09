//https://leetcode.com/problems/remove-duplicate-letters/
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] charArray = new int[26];
        for(int index=0; index < s.length(); index++){
            charArray[s.charAt(index) -'a']++;
        }
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        char startingChar = 'a';
        for(int index=0; index < charArray.length; index++){
           if(charArray[index] > 0){
               startingChar = (char) (index + (int) 'a');
               break;
           }
        }
        boolean started = false;
        Stack<Character> stack = new Stack<>();
        for(int index = 0; index < s.length(); index++){
            if(stack.empty()){
                stack.push(s.charAt(index));
                seen.add(s.charAt(index));
                charArray[s.charAt(index) - 'a']--; 
            }else{
                if(!seen.contains(s.charAt(index))){ 
                    while(true){
                        if(stack.empty()){
                            stack.push(s.charAt(index));
                            seen.add(s.charAt(index));
                            charArray[s.charAt(index) - 'a']--; 
                            break;
                        }
                        char lastElement = stack.peek();
                        if(s.charAt(index) > lastElement){
                            stack.push(s.charAt(index));
                            seen.add(s.charAt(index));
                            charArray[s.charAt(index) - 'a']--; 
                            break;
                        }else if(s.charAt(index) < lastElement){
                            if(charArray[lastElement - 'a'] >= 1){
                                stack.pop();
                                seen.remove(lastElement);
                            }else if(charArray[lastElement - 'a'] == 0){
                                stack.push(s.charAt(index));
                                seen.add(s.charAt(index));
                                charArray[s.charAt(index) - 'a']--; 
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }else{ 
                    charArray[s.charAt(index) - 'a']--; 
                    
                }
            }
        }
        Stack<Character> newStack = new Stack<>();
        
        while(!stack.empty()){
            char letter = stack.pop();
            newStack.push(letter);
        }
        while(!newStack.empty()){
            result.append(newStack.pop());
        }
        
        return result.toString();
    }
}
