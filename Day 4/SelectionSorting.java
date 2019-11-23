//Author : Abel Tsegaye

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;



public class SelectionSorting{
    static int smallest;
    static int index_of_smallest;

//Finds and returns the smallest integer in a given list 
    public static int[] find_smallest(int[] list){
        smallest = list[0];
        index_of_smallest = 0;
            for(int j=0; j< list.length; j++){
                if(list[j]<list[0]){
                    if(list[j]<=smallest){
                        smallest = list[j];
                        index_of_smallest = j;
                        }   
                }
            }

            int[] result = {smallest,index_of_smallest}; 
            return result;
        
    }

    //Sorts the given array
    public static void sort(int[] list){
        int counter = 0;
        int left_most_num = 0;
        while(counter < list.length){
            int smallest = find_smallest(Arrays.copyOfRange(list,counter,list.length))[0]; //Slices the index and finds the smallest integer
            int index_of_smallest = find_smallest(Arrays.copyOfRange(list,counter,list.length))[1]+counter;//gives the index of the smallest number
            left_most_num = list[counter]; 
            list[counter] =smallest;//puts the smallest integer to the left most
            list[index_of_smallest]=left_most_num; //swaps the smallest integer with the left most number of unsorted part of the list
            counter++;

        }
        return list;
        

        
    }
    //Generates random numbers from up to the given numbers with no duplicates 
    public static int[] randomGenerator(int size){
        Random random = new Random();
        int counter = 0;
        int generatod;
        int[] random_generatod = new int[size];
        HashMap map = new HashMap<Integer,Integer>();
        while(counter < size){
            Integer num = random.nextInt(size+1);
            if(!map.containsKey(num)){
                map.put(num,num);
                random_generatod[counter] = num;
                counter++;

            }
            
            
            
        }
        return random_generatod;
        
    }
    public static void main(String args[]){
        int[] g_list = randomGenerator(10000);
        sort(g_list);

        for(int i = 0;i < g_list.length; i++){

            System.out.println(g_list[i] + "");
        }
    }
}