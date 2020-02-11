import java.util.HashMap;
import java.util.HashSet;

class UniqueMorseCode {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<Integer,String> mapper = new HashMap<Integer,String>();
        HashSet<String> check = new HashSet<String>();
        int start = Character.getNumericValue('a');
        for(int i = 0; i < codes.length; i++){
            mapper.put(start,codes[i]);
            start++;
        }
        
        for(int i = 0; i < words.length; i++){
            String code_converted = "";
            for(int j = 0; j < words[i].length(); j++){
                code_converted += mapper.get(Character.getNumericValue(words[i].charAt(j)));
            }
            check.add(code_converted);
        }
        
        return check.size();
    }
}