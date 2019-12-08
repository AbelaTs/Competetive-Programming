import java.util.Arrays;
import java.util.List;
import java.util.*; 

class PancakeSorting {
    static List<Integer> result;
    public static List<Integer> pancakeSort(int[] A) {
        result = new ArrayList<Integer>();
        int start = A.length - 1;
        while(start >= 0){
          
            int[] temp = Arrays.copyOfRange(A, 0,  start + 1);
            int largest = findLargest(temp);
            if(!isRightPlaced(largest, start, A)){
                result.add(getIndex(largest, A)+1);
                reverse(A,getIndex(largest, A));//moving the element to the first index
                result.add(start+1);
                reverse(A, start);//moving the element to the right most since the its the largest number
            }
            start--;

        }
        return result;

    }
    //gets the index of the number in the array
    public static int getIndex(int number, int[] input){
        for(int i = 0; i < input.length; i++){
            if(input[i] == number){
                return i;
            }
        }
        return -1;
    }
    //Check if the number is at its right place
    public static boolean isRightPlaced(int number,int index, int[] input){
        for(int i = 0; i < input.length; i++){
            if(input[i] == number){
                if(i == index){
                    return true;
                }
            }
        }
        return false;
    }


    //finds the largest number
    public static int findLargest(int[] list){
        int largest = list[0];
        for(int x = 0; x<list.length; x++){
            if(list[x] >= largest){
                largest = list[x];
            }
        }
        return largest;
    }
    // Reverses the list starting from the given index
    public static void reverse(int[] input,int index){
        int[] temp = new int[index + 1];
        int counter = 0;
        for(int i = index; i >= 0;i--){
           temp[counter] = input[i];
           counter++;
        }
        for(int i = 0; i< temp.length; i++){
            input[i] = temp[i];
        }
       
        
        
    }
    public static void main(String args[]){
        int[] list = {3,2,4,1};
        List<Integer> res = pancakeSort(list);
        for(int x = 0; x<res.size(); x++){
            System.out.println(res.get(x));
        }
    }
}