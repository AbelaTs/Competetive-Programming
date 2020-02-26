//https://leetcode.com/problems/minimum-increment-to-make-array-unique/
class  MinimumIncrementtoMakeArrayUnique{
    public int minIncrementForUnique(int[] A) {
        int count_increment = 0;
        if(A.length > 0){
            countSort(A);
            for(int i = 1; i < A.length; i++){
                if(A[i] <= A[i-1]){
                   while(A[i] <= A[i-1]){
                       A[i] += 1;
                       count_increment++;
                   } 
                }
            }
        }
        return count_increment;
        
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