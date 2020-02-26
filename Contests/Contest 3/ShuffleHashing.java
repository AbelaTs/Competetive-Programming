//http://codeforces.com/contest/1278/problem/A
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class ShuffleHashing{
    static String h_string;
    public static String check(String original,String hashed){
        h_string = hashed;
        ArrayList<Character> or_store = new ArrayList<Character>();
        ArrayList<Character> hsh_store = new ArrayList<Character>();

        for(int i = 0; i< original.length(); i++){
            or_store.add(original.charAt(i));
        }

        for(int i = 0; i< hashed.length(); i++){
            hsh_store.add(hashed.charAt(i));
        }

       
        if(original.length() <= hashed.length()){
            if(check_presence(or_store, hsh_store)){
                return "YES";
            }else{
                return "NO";
            }

        }else{
            return "NO";
        }
    }
    //chek one includes the other
    public static boolean check_presence(ArrayList<Character> l1,ArrayList<Character> l2){
        if(l2.size() > l1.size()){
            char[] input1 = new char[l2.size()];
            char[] test;
        
            int start = 0;
        
        
            for(int j = 0; j < l2.size(); j++){
                input1[j] = (char) l2.get(j); 
            }
            //Checks each substring if they are the anagram of the original string
            for(int i = 0; i < input1.length - l1.size()+1; i++){
                int end = start + l1.size();
                test = Arrays.copyOfRange(input1, start, end);
                ArrayList<Character> temp  = new ArrayList<Character>();
                
                //readding the original given string
                for(int b = 0; b < l1.size(); b++){
                    temp.add(l1.get(b));
                }
                //checking for anagram
                for(int x = 0; x < test.length; x++){
                    if(!temp.contains(test[x])){
                        break;
                    }else{
                        temp.remove(Character.valueOf(test[x]));
                    }
                    
                }

                if(temp.isEmpty()){
                    return true;
                }
                start++;
            
            }
            return false;
       }else{
           //If length of both original and hashed are equal
           for(int i = 0; i< l2.size(); i++){
               if(l1.contains(l2.get(i))){
                  int index = l1.indexOf(h_string.charAt(i));
                  l1.remove(index);
               }else{
                  return false;
               }
           }
           return true;
       }
        
    }
    public static void main(String[] args) {
        
        Scanner scanner  = new Scanner(System.in);
        int iterator = scanner.nextInt();
        scanner.nextLine();
        String[] result = new String[iterator];
        int counter = 0;
      
        while(iterator > 0){
            String input1 = scanner.nextLine();
            String input2 = scanner.nextLine();
            result[counter] = check(input1,input2); 
            iterator--;
            counter++;           
        }
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}