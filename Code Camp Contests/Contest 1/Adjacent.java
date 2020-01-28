
public class Adjacent {
    public String removeDuplicates(String s, int k) {
        int counter = 0;
        boolean found_dup = false;
        while(counter < s.length()){
            found_dup = false;
            if(counter+k <= s.length()){
                if(checkDuplicate(s.substring(counter,counter+k))){ 
                    s = s.substring(0,counter)+s.substring(counter+k);
                    found_dup = true;
                }
            }
            if(found_dup){
                counter = 0;
            }else{
                counter++;
             }
        }

        return s;
    }
    public boolean checkDuplicate(String s){
        for(int i = 0; i < s.length() -1; i++){
            if(s.charAt(i) != s.charAt(i+1)){
                return false;
            }            
        }
        return true;
    }
}
        