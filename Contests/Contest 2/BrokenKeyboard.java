import java.util.ArrayList;
import java.util.Scanner;

public class BrokenKeyboard{
    public static Long getSubstringCount(String given, String available){
            ArrayList<Character> avail_word = new ArrayList<Character>();
            ArrayList<Character> given_word = new ArrayList<Character>();
            for(int i = 0; i < given.length(); i++){
                given_word.add(given.charAt(i));
            }
            for(int i = 0; i < available.length(); i++){
                avail_word.add(available.charAt(i));
            }
            Long count = 0L;
            Long subs_count = 0L;
            for(int i = 0; i < given_word.size(); i++){
                if(avail_word.contains(given_word.get(i))){
                    count++;
                }else{
                    Long sub_soFar = (count*(count+1))/2;
                    subs_count += sub_soFar; 
                    count = 0L;     
                }
            }
            //
            Long sub_soFar = (count*(count+1))/2;
            subs_count += sub_soFar; 
            count = 0L;  

            return subs_count;
    }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String count = scanner.nextLine();
       String given = scanner.nextLine();
       String keys = scanner.nextLine();
       keys = keys.replaceAll("\\s+","");
       System.out.println(getSubstringCount(given,keys));
    }
}