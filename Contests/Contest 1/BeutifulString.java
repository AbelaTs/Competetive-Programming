//https://codeforces.com/contest/1265/problem/A
import java.util.Scanner;
public class BeutifulString {

    public static int CheckDuplicate(String a){
        for(int x =0; x<a.length()-1;x++){
            if(a.charAt(x) != '?' && a.charAt(x) ==  a.charAt(x+1)){
                return -1;
            }
        }
        return 0;
    }

    static char[] values = new char[]{'a','b','c'};
    public static String stringMaker(String a){
        int check = CheckDuplicate(a);
        if(check == 0){
        StringBuilder a_builder = new StringBuilder(a); 
        for(int x=0; x<a_builder.length(); x++){
            if(a.charAt(x) == '?'){
             

                    if(x == 0){
                        if(a_builder.length() == 1){
                             a_builder.setCharAt(x, values[0]);
                        }else{
                        
                            if(a_builder.charAt(x+1) == 'c'){
                               int res = (int)a_builder.charAt(x+1) - 1;
                                char next = (char) res;
                                a_builder.setCharAt(x,next);
                            }else if(a_builder.charAt(x+1) == '?'){
                                a_builder.setCharAt(x, values[0]);
                            }else{
                                int res = (int)a_builder.charAt(x+1) + 1;
                                char next = (char) res;
                                a_builder.setCharAt(x,next);
                            }
                                   
                    }
                    }else if( x == a_builder.length() - 1){
                        
                            if(a_builder.charAt(x-1) == 'c'){
                                int res = (int)a_builder.charAt(x-1) - 1;
                                char next = (char) res;
                                a_builder.setCharAt(x,next);
                            }else{
                                int res = (int)a_builder.charAt(x-1) + 1;
                                char next = (char) res;
                                a_builder.setCharAt(x,next);
                            }
                    }else{
                         for(int y=0; y<values.length; y++){
                            if(values[y] != a_builder.charAt(x-1) && values[y] != a_builder.charAt(x+1)){
                               
                               a_builder.setCharAt(x,values[y]);
                               break;
                            }
                        }
                    }
                
            }
        }
        return a_builder+"";
        }else{
            return "-1";
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = scanner.nextInt();
        int index = counter - 1;
        
        String s1 = "";
        String[] result = new String[counter];
        
        while(counter > 0){
            s1 = scanner.next();
            result[index] = stringMaker(s1);
            counter--;
            index--;
        }

        for(int x = result.length -1 ; x>=0; x--){
          System.out.println(result[x]);
        }
        
      
   
       
    }
    
}
