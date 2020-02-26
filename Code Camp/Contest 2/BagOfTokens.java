//https://leetcode.com/problems/bag-of-tokens/
class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        int points = 0;
        int count = 0;
        int max_point = 0;
        if(tokens.length > 0){
            countSort(tokens);
            int initial = 0;
            int end = tokens.length -1;
            while(initial <= end){
                if(P>=tokens[initial]){
                    P -= tokens[initial];
                    points++;
                    if(points > max_point){
                        max_point = points;
                    }
                    initial++;
                }else{
                    if(points > 0){
                        P += tokens[end];
                        end -= 1;
                        points--;
                    }else{
                        return points;
                    }
                }
            }
        }
        return max_point;
        
    }
    
    //Counting sort
    public static void countSort(int[] list){
        int counter = 0;
        //finding the largest number
        int largest = list[0];
        for(int i=0; i<list.length; i++){
            if(list[i] > largest){
                largest = list[i];
            }
        }
        
        //Setting the counting array
        int[] count_sort = new int[largest+1];
        for (int x=0; x < count_sort.length; x++){
            count_sort[x] = 0;
        }
      
        //Counting occurance of each member
        for(int y=0; y<list.length; y++){
            count_sort[list[y]] += 1;
        }
        
        //resorting the array
        for(int j=0; j<count_sort.length; j++){
            while(count_sort[j] > 0){
                list[counter] = j;
                counter++;
                count_sort[j]--;
            }
        }
        
    }
}
