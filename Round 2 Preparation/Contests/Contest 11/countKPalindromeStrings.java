class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length()){
            return false;
        }
        HashMap<String,Integer> occCounter = new HashMap<>();
        for(int index = 0; index < s.length(); index++){
            if(occCounter.containsKey(String.valueOf(s.charAt(index)))){
                occCounter.put(String.valueOf(s.charAt(index)),occCounter.get(String.valueOf(s.charAt(index)))+1);
            }else{
                occCounter.put(String.valueOf(s.charAt(index)),1);
            }
        }
        
        int oddCounter = 0;
        for (Integer value : occCounter.values()) {
            if((int) value % 2 != 0){
                oddCounter++;
            }
        }
        if(oddCounter > k){
            return false;
        }
        return true;
    
    }
}
