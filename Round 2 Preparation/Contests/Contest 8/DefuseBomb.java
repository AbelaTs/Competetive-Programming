//https://leetcode.com/contest/biweekly-contest-39/problems/defuse-the-bomb/
class Solution {
    public int[] decrypt(int[] code, int k) {
        if(code.length == 0){
            return code;
        }
        int[] result = new int[code.length];
        for(int index = 0; index < code.length; index++){
            int counter = 0;
            int sum = 0;
            
            if(k > 0){
                int indexCounter = index + 1;
                while(counter < Math.abs(k)){
                    if(indexCounter == code.length){
                        indexCounter = 0;
                    }
                    sum += code[indexCounter];
                    indexCounter++;
                    counter++;
                }
              result[index] = sum;
            }else if(k < 0){
                int indexCounter = index - 1;
               while(counter < Math.abs(k)){
                    if(indexCounter == -1){
                        indexCounter = code.length-1;
                    }
                    sum += code[indexCounter];
                    indexCounter--;
                    counter++;
                }
              result[index] = sum;
            }else{
                result[index] = 0;
            }
            
        }
        return result;
        
        
        
    }
}