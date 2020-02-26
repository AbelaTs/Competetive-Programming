//https://leetcode.com/problems/top-k-frequent-words/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> mapper = new HashMap<String,Integer>();
        PriorityQueue<WordCounter> maxHeap = new PriorityQueue<>(new WordComparator());
        for(int i = 0; i < words.length; i++){
            if(mapper.containsKey(words[i])){
                mapper.put(words[i],mapper.get(words[i])+1);
            }else{
                mapper.put(words[i],1);
            }
        }
        
        for(String key : mapper.keySet()){
            WordCounter word = new WordCounter(key, (int) mapper.get(key));
            maxHeap.add(word);
        }
        
        ArrayList<String> res = new ArrayList<String>();
        
        for(int i = 0; i < k; i++){
            res.add(maxHeap.poll().word);
        }
        
        return res;
    }
    
}
class WordCounter{
    String word;
    int counter;
    public WordCounter(String g_word, int c){
        word = g_word;
        counter = c;
    }
}

class WordComparator implements Comparator<WordCounter>{
    @Override
    public int compare(WordCounter w1, WordCounter w2){
        if(w1.counter < w2.counter){
            return 1;
        }else if(w1.counter > w2.counter){
            return -1;
        }else{
            if(w1.word.compareTo(w2.word) < 0){
                return -1;
            }else if(w1.word.compareTo(w2.word) > 0){
                return 1;
            }
            return 0;
        }
        
    }
}