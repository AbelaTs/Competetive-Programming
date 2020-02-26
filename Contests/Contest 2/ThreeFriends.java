//http://codeforces.com/contest/1272/problem/A
import java.util.Scanner;

public class ThreeFriends {
    public static  void sortLargest(int[] list){
        int temp;
        for(int i = 1; i < list.length; i++){
            int counter = i;
            while(counter > 0){
                if(list[counter] > list[counter-1]){
                    temp = list[counter - 1];
                    list[counter - 1] = list[counter];
                    list[counter] = temp;
                    
                }
                counter--;
            }
        }
    }
    public static  int getMinDistance(int[] list){
        sortLargest(list);
    
        int sum = 0;
        for(int i = 0; i < list.length-1; i++){
            if(i != 1){
                if(list[i] < list[i+1]){
                    if(list[i+1] - list[i] > 1){
                        list[i] += 1;
                        list[i+1] -= 1;
                    }else{
                        list[i] += 1;
                    }
                }else if(list[i] > list[i+1]){
                    if(list[i] - list[i+1] > 1){
                        list[i] -= 1;
                        list[i+1] += 1;
                    }else{
                        list[i] -= 1;
                    }
                }else{
                    if(list[i] < list[i+2]){
                        list[i] += 1;
                    }else if(list[i] > list[i+2]){
                        list[i] -= 1;
                        list[i+1] -= 1;
                    }
                }
            }else{
                if(list[i] > list[i+1]){
                    list[i+1] += 1;
                }else if(list[i] < list[i+1]){
                    list[i+1] -= 1;
                }
            }
      
        }
        //calculate the sum
        sum = Math.abs(list[0] - list[1]) + Math.abs(list[0] - list[2]) + Math.abs(list[1] - list[2]);
        return sum;

    }
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int iterator = scanner.nextInt();
        scanner.nextLine();
        int[] result = new int[iterator];
        int counter = 0;
      
        while(iterator > 0){
            
            String input = scanner.nextLine();
            String[] in = input.split(" ");
            int[] nums = new int[in.length];
            for(int i = 0; i<in.length; i++ ){
                nums[i] = Integer.parseInt(in[i]);
            }
            
            result[counter] = getMinDistance(nums);
            counter++;
            iterator--;
        }
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}