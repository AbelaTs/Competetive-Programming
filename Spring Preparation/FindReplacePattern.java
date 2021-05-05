//https://leetcode.com/problems/find-and-replace-pattern/
class Solution {
    public List findAndReplacePattern(String[] words, String pattern) {
    
       String origIntegerPattern = makeIntegerPattern(pattern);
        List<String> result = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String patternOfWords = makeIntegerPattern(words[i]);
            if(patternOfWords.equals(origIntegerPattern)){
                result.add(words[i]);
            }
            
        }
        return result;
        
        
    }
    
    public  String makeIntegerPattern(String pattern){
         HashMap<Character,Integer> h = new HashMap<>();
         String numPattern = "";
        for(int i =0;i<pattern.length();i++){
            if(h.containsKey(pattern.charAt(i))){
                numPattern = numPattern +  h.get(pattern.charAt(i));
            }else{
                 numPattern = numPattern + i;
                h.put(pattern.charAt(i),i);
               
            }
        }
        return numPattern;
    }
    }