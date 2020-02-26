//https://leetcode.com/problems/most-common-word/
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] list_words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\W+");
        HashMap<String,Integer> mapper = new HashMap<String,Integer>();
        HashMap<String,Integer> banned_mapper = new HashMap<String,Integer>();
        PriorityQueue<WordCounter> maxHeap = new PriorityQueue<>(new WordComparator());
        //counting the words
        for(int i = 0; i < list_words.length; i++){
            if(mapper.containsKey(list_words[i])){
                mapper.put(list_words[i],mapper.get(list_words[i])+1);
            }else{
                mapper.put(list_words[i],1);
            }
        }
        //store banned words
        for(int i = 0; i < banned.length; i++){
            banned_mapper.put(banned[i],1);
        }
        //build the heap
        for(String key : mapper.keySet()){
            WordCounter word = new WordCounter(key, (int) mapper.get(key));
            maxHeap.add(word);
        }
        //getting the max count
        String result = "";
        Iterator iterator = maxHeap.iterator();
        while(iterator.hasNext()){
            result = maxHeap.poll().word;
            if(!banned_mapper.containsKey(result)){
                break;
            }
        }
        return result;
        
        
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