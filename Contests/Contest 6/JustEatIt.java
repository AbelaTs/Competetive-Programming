import java.security.DrbgParameters.Reseed;
import java.util.Scanner;
import java.util.Arrays;
public class JustEatIt{
    public static String getTastes(String[] nums){
        int[] nums_list = new int[nums.length];
        //Changing input into integers
        for(int i = 0; i < nums.length; i++){
            nums_list[i] = Integer.parseInt(nums[i]);
        }

        int ideal_sum = 0;//Sum with all posetive
        int real_sum = 0;//Sum with all negative
        
        for(int i = 0; i < nums_list.length; i++){
            ideal_sum += Math.abs(nums_list[i]);
            real_sum += nums_list[i];
        }
        int[] fout = new int[nums.length - 1];
        int counter = 0;
        for(int i = 1; i < nums_list.length; i++){
            fout[counter] = nums_list[i];
            counter++;
        }

        int[] lout = new int[nums.length - 1];
        int counter2 = 0;
        for(int i = 0; i < nums_list.length-1; i++){
            lout[counter2] = nums_list[i];
            counter2++;
        }
        fout = mergeSort(fout);
        lout = mergeSort(lout);
        
        int largestF = fout[fout.length - 1];
        int second_largestF = fout[fout.length - 2];
        int largestL = lout[lout.length - 1];
        int second_largestL = lout[lout.length - 2];

        for(int i = 0; i < nums_list.length-1; i++){
            if(nums_list[i]  >= real_sum){
                return "NO";
            }
        }
        if(ideal_sum == real_sum){
            return "YES";
        }else{
            if(largestF+second_largestF >= real_sum || largestL+second_largestL >= real_sum){
                return "NO";
            }else{
                return "YES";
            }
        }
        

        

    }
     // merges the two half parst of the list into one list in an increasing order manner
     public static int[] merge(int[] left_list,int[] right_list){
        int merge_list_length = left_list.length + right_list.length;
        int[] merge_list = new int[merge_list_length];
        int left_pointer = 0;
        int right_pointer = 0;
        
        int merged_list_pointer = 0;

        while(merged_list_pointer < merge_list_length){
           if(left_pointer < left_list.length && right_pointer < right_list.length){
                if(left_list[left_pointer] <= right_list[right_pointer]){
                    merge_list[merged_list_pointer] = left_list[left_pointer];
                    left_pointer++;
                }else{
                merge_list[merged_list_pointer] = right_list[right_pointer];
                right_pointer++;
                }
                merged_list_pointer++;


           }else{
               if(left_pointer >= left_list.length){
                   for(int i = right_pointer; i< right_list.length; i++){
                       merge_list[merged_list_pointer] = right_list[right_pointer];
                       right_pointer++;
                       merged_list_pointer++;
                   }
               }else if(right_pointer >= right_list.length){
                    for(int i = left_pointer; i< left_list.length; i++){
                        merge_list[merged_list_pointer] = left_list[left_pointer];
                        left_pointer++;
                        merged_list_pointer++;
                }
               }
           }
           
        }

        return merge_list;
    }

    // sorts a gien list in an increasing order
    public static int[] mergeSort(int[] list){
        int[] left_list = Arrays.copyOfRange(list,0,list.length/2);
        int[] right_list = Arrays.copyOfRange(list,list.length/2,list.length);

        if(list.length == 1){
            return list;
        }else{
            left_list = mergeSort(left_list);
            right_list = mergeSort(right_list);
        }
        return merge(left_list,right_list);


    }
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int iterator = scanner.nextInt();
        scanner.nextLine();
        String[] result = new String[iterator];
        int counter = 0;
      
        while(iterator > 0){
            int size = scanner.nextInt();
            scanner.nextLine();
            String input = scanner.nextLine();
            String[] input_nums = input.split(" ");
            result[counter] = getTastes(input_nums); 
            counter++;
            iterator--;
        }
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}