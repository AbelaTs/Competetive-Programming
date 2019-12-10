import java.util.Scanner;
public class BeutifulNumber2{
    public static int[] beutifulMaker(int[] list){
        int[] result = new int[list.length];
        
        int[] index_holder = new int[list.length];
        for(int i = 0; i < list.length; i++){
            int num = list[i];
            index_holder[num - 1] = i;
        }
        int min = index_holder[0];
        int max = index_holder[0];

        for(int i=0; i<index_holder.length; i++){
            if(index_holder[i] < min){
                min = index_holder[i]; 
            }
            if(index_holder[i] > max){
                max = index_holder[i];
            }
            
            if(max - min == i){
                
                result[i] = 1;
            }else{
                result[i] = 0;
            }
        }

        
        return result;
    }

     //Takes string input and prints out the final result in string form
     public static String printBeutifulNumber(String num){
        String[] s_num = num.split("\\s+");// converting given string to string array
        int[] input_num = new int[s_num.length];
        for(int i = 0; i<s_num.length; i++){
            input_num[i] = Integer.parseInt(s_num[i]);
        }//Convert given string to int array
        int[] result = beutifulMaker(input_num);
        String result_string = "";
        for(int i = 0; i < result.length; i++){
            result_string += Integer.toString(result[i]);
        }//Convert result to string

        return result_string;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iteration  = scanner.nextInt();
        String[] inputs = new String[iteration];
        int counter = 0;
      
        while(iteration > 0){
            int len1 = scanner.nextInt();
            scanner.nextLine();
            String input = scanner.nextLine();
            inputs[counter] = input;
            counter++;
            iteration--;
        }
        for(int i = 0; i < inputs.length; i++){
            System.out.println(printBeutifulNumber(inputs[i]));
        }
        
    }
}