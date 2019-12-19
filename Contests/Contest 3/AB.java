import java.util.Scanner;

public class AB{
    static int counter;
    public static int getMinimum(int num1, int num2){
        int initial = 0;
        int min_num;
        int lar_num;
        counter = 0;
        if(num1 >= num2){
            min_num = num2;
            lar_num = num1;
        }else{
            min_num = num1;
            lar_num = num2;
        }
        while(true){
            //when they are equal get out of the loop
           if(min_num == lar_num){
                break;
            }
           initial+=1;
           if(min_num + initial <= lar_num){
                min_num += initial;
           }else{
               lar_num += initial;
           }
           counter++;
           
           
        }
        return counter;
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
            
            result[counter] = getMinimum(nums[0],nums[1]);
            counter++;
            iterator--;
        }
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}