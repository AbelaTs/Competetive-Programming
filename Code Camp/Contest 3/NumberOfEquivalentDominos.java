//https://leetcode.com/problems/number-of-equivalent-domino-pairs/
import java.util.HashMap;

class NumberOfEquivalentDominos {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer> mapper = new HashMap<String,Integer>();
        int counter = 0;
        for(int i = 0; i < dominoes.length; i++){
            if(mapper.containsKey(dominoes[i][0]+""+dominoes[i][1])){
                counter+= mapper.get(dominoes[i][0]+""+dominoes[i][1]);
                mapper.put(dominoes[i][0]+""+dominoes[i][1],mapper.get(dominoes[i][0]+""+dominoes[i][1])+1);  
                
            }
            if(dominoes[i][0] != dominoes[i][1]){
                if(mapper.containsKey(dominoes[i][1]+""+dominoes[i][0])){
                    counter+=mapper.get(dominoes[i][1]+""+dominoes[i][0]);

                }
            }
            if(!mapper.containsKey(dominoes[i][0]+""+dominoes[i][1])){
                mapper.put(dominoes[i][0]+""+dominoes[i][1],1);
            }
        }
        return counter;
    }
    
    }
