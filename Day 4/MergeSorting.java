//Author : Abel Tsegaye

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MergeSorting{
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

    public static void main(String args[]){
        int[] list = {5,8,9,3,6};
        int[] result = mergeSort(list);
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
    
}