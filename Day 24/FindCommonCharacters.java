//https://leetcode.com/problems/find-common-characters/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        HashMap<Character,Integer> check = new HashMap<Character,Integer>();
        HashMap<Character,Boolean> check_exist = new HashMap<Character,Boolean>();
        //Store all the first character in the first string
        for(int i = 0; i < A[0].length(); i++){
            if(check.containsKey(A[0].charAt(i))){
                check.put(A[0].charAt(i),check.get(A[0].charAt(i))+1);
            }else{
                check.put(A[0].charAt(i),1);
                check_exist.put(A[0].charAt(i),true);
            }
        }
        
        //check for the count of occurance of each common character and keep the minimum count
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[i].length(); j++){
                if(check.containsKey(A[i].charAt(j))){
                    //count the occurance the common character
                    int count = 0;
                    for( int k = 0; k < A[i].length(); k++){
                        if(A[i].charAt(k) == A[i].charAt(j)){
                            count++;
                        }
                    }
                    //Keep the minimum count of the common character
                    if(count < check.get(A[i].charAt(j))){
                      check.put(A[i].charAt(j),count);
                    }
                    
                }
            }
        }
        
        //check if each character exista in every string
        for(int i = 1; i < A.length; i++){
           for(Character key : check.keySet()){
               if(A[i].indexOf((char) key) < 0){
                   check_exist.put(key,false);
               }
           }
        }
        
        ArrayList<String> res = new ArrayList<String>();
        for(Character key : check.keySet()){
           
                if(check_exist.get(key)){
                   
                    int count = (int)check.get(key);
                    while(count > 0){
                        res.add(String.valueOf((char)key));
                        count--;
                    }
                }
            
        }

        return res;
    }
}