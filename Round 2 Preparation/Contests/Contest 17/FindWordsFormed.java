//https://leetcode.com/contest/weekly-contest-150/problems/find-words-that-can-be-formed-by-characters/
class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> charCounter = new HashMap<>();
        for(int index = 0; index <  chars.length(); index++){
            if(!charCounter.containsKey(chars.charAt(index))){
                charCounter.put(chars.charAt(index),1);
            }else{
                charCounter.put(chars.charAt(index), charCounter.get(chars.charAt(index))+1);
            }
            
            
        }
        int counter = 0;
        for(String word : words){
            boolean found = true;
            ArrayList<Character> removedChars = new ArrayList<>();
            for(int index = 0; index < word.length(); index++){
                if(!charCounter.containsKey(word.charAt(index))){
                    found = false;
                    break;
                }else{
                    if(charCounter.get(word.charAt(index)) <= 0){
                        found = false;
                        break;
                    }else{
                        removedChars.add(word.charAt(index));
                        charCounter.put(word.charAt(index),charCounter.get(word.charAt(index))-1);
                    }
                }
            }
            if(found){
                counter+=word.length();
            }
            populateMap(charCounter,removedChars);
        }
        return counter;
        
    }
    public void populateMap(HashMap<Character,Integer> charCounter,ArrayList<Character> chars){
        for(int index = 0; index <  chars.size(); index++){
            if(!charCounter.containsKey(chars.get(index))){
                charCounter.put(chars.get(index),1);
            }else{
                charCounter.put(chars.get(index), charCounter.get(chars.get(index))+1);
            }
            
            
        }
    }
}
