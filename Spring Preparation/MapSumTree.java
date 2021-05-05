//https://leetcode.com/problems/map-sum-pairs/
class MapSum {
    HashMap<String,Integer> map=null;
    /** Initialize your data structure here. */
    public MapSum() {
        map=new HashMap<String,Integer>();
    }
    
    public void insert(String key, int val) {
        map.put(key,val);
    }
    
    public int sum(String prefix) {
        int sum=0;
        for(String key:map.keySet()){
            if(key.startsWith(prefix)){
                sum+=map.get(key);
            }
        }
        return sum;
    }
}
