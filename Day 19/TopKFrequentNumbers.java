//https://leetcode.com/problems/top-k-frequent-elements/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mapper = new HashMap<Integer,Integer>();
        PriorityQueue<Element> maxHeap = new PriorityQueue<>(new ElementComparator());
        for(int i = 0; i < nums.length; i++){
            if(mapper.containsKey(nums[i])){
                mapper.put(nums[i],mapper.get(nums[i])+1);
            }else{
                mapper.put(nums[i],1);
            }
        }
        
        for(Integer key : mapper.keySet()){
            Element element = new Element((int) key, (int) mapper.get(key));
            maxHeap.add(element);
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < k ; i++){
            Element element = maxHeap.poll();
            res.add(element.value);
        }
        
        return res;
        
    }
}
class Element{
    int value;
    int count;
    public Element(int element_val,int element_count){
        value = element_val;
        count = element_count;
    }
}

class ElementComparator implements Comparator<Element>{
    @Override
    public int compare(Element e1, Element e2){
        if(e1.count < e2.count){
            return 1;
        }else if(e1.count > e2.count){
            return -1;
        }
        return 0;
    }
}