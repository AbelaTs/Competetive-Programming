//https://leetcode.com/problems/h-index
class HIndex {
    public int hIndex(int[] citations) {
        int count = 0;
        int at_least = 0;
       
            for(int i = 0; i< citations.length; i++){
                count = 0;
                for (int j = 0; j < citations.length; j++){
                    if(citations[j] - citations[i] >= 0){
                        count++;
                    }
                    if(citations[i] >= count){
                        if(count > at_least){
                            at_least = count;
                        }
                    }else{
                         if(citations[i] > at_least){
                            at_least = citations[i];
                        }
                    }
                 
                }
            }
            return at_least;

    }
}