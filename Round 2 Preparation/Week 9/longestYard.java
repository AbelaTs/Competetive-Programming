class Solution {
    public int longestStrChain(String[] words) {
        int[] longestTrack = new int[words.length];
        HashMap<String,ArrayList<String>> adjList = new HashMap<>();
        HashMap<String,Integer> memory = new HashMap<>();
        int maxChain = 1;
        //making the adjecency list
        for(int index = 0; index <  words.length; index++){
            for(int subIndex = 0; subIndex < words.length; subIndex++){
                if(subIndex != index){
                    if(check(words[index],words[subIndex])){
                        if(!adjList.containsKey(words[index])){
                            ArrayList<String> wordsList = new ArrayList<>();
                            adjList.put(words[index],wordsList);
                        }
                        adjList.get(words[index]).add(words[subIndex]);
                    }
                }
            }
            
        }
        //going DFS
        for(String key : adjList.keySet()){
            int count = goDFS(adjList,memory,key); 
            if(count > maxChain){
                maxChain = count;
            }
        }
        return maxChain;
    }
    public int goDFS(HashMap<String,ArrayList<String>> adjList,HashMap<String,Integer> memory,String word){
        if(memory.containsKey(word)){
            return memory.get(word);
        }
        if(!adjList.containsKey(word)){  
            return 1; 
        }
        int max = 0;
        for(int index = 0; index <  adjList.get(word).size(); index++){
            int counter = goDFS(adjList,memory,adjList.get(word).get(index));
            counter++;
            max = Math.max(counter,max);
        }
        if(!memory.containsKey(word)){
            memory.put(word,max);
        }
        return max;
    }
    public boolean check(String word, String word2){
        if(word.length() >= word2.length() || word.length() <= word2.length()-2){
            return false;
        }
        for(int index = 0; index < word.length(); index++){
            if(!word2.contains(String.valueOf(word.charAt(index)))){
                return false;
            }
        }
        int wordPointer = 0;
        int word2Pointer = -1;
        for(int index = 0; index < word2.length(); index++){
            if(word2.charAt(index) == word.charAt(0)){
                word2Pointer = index;
                break;
            }
        }
        while(wordPointer < word.length() && word2Pointer < word2.length()){
            if(word.charAt(wordPointer) == word2.charAt(word2Pointer)){
                wordPointer++;
                word2Pointer++;
            }else{
                 word2Pointer++;
            }
        }
        if(wordPointer < word.length()){
            return false;
        }
        
        return true;
    }
}
