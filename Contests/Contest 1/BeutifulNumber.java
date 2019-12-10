import java.util.ArrayList;
import java.util.Scanner;
public class BeutifulNumber{

    //Gets the permituation of numbers
    public static ArrayList<Integer> getPermituation(int num){
        ArrayList<Integer> permituation_nums = new ArrayList<Integer>();
        while(num > 0){
            permituation_nums.add(num);
            num--;
        }
        return permituation_nums;
    }

    //Returns list of beutiful numbers
    public static int[] checkBeutifulNumber(int[] list){
        int[] result = new int[list.length];
        boolean not_started ;
        for(int i = 0; i < list.length; i++){
            if(list[i] == 1){
                result[list[i] - 1] = 1;
            }else{
                ArrayList<Integer> perm_list = getPermituation(list[i]);
                not_started = true;//Check if it has already started with its permituation


                for(int j = 0; j<list.length; j++){
                        if(perm_list.contains(list[j])){
                            not_started = false;
                           // System.out.println(list[i] + " : " +list[j]);
                            perm_list.remove(Integer.valueOf(list[j]));

                            if(perm_list.isEmpty()){
                                //System.out.println(list[i] + ": 1");
                                result[list[i] - 1] = 1;
                                break;
                            }
                        }else{
                            if(!not_started){
                                //System.out.println(list[i] + ": 0");
                                result[list[i] - 1] = 0;
                                break;
                            }
                        }
                }
               
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
        int[] result = checkBeutifulNumber(input_num);
        String result_string = "";
        for(int i = 0; i < result.length; i++){
            result_string += Integer.toString(result[i]);
        }//Convert result to string

        return result_string;
    }


    public static void main(String args[]){
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