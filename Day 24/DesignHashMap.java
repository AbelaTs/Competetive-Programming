//https://leetcode.com/problems/design-hashmap/
import java.util.Arrays;
class DesignHashMap {
    int[] hash_map;
    /** Initialize your data structure here. */
    public DesignHashMap() {
        hash_map = new int[1000001];
        Arrays.fill(hash_map,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hash_map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(hash_map[key] == -1){
            return -1;
        }
        return hash_map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hash_map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */