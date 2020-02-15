import java.util.HashMap;

class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        int[] alphabets = new int[27];
        char[] chars = new char[S.length()];
        HashMap<Character,Integer> mapper = new HashMap<Character,Integer>();
        HashMap<Integer,Character> index_mapper = new HashMap<Integer,Character>();
        
        
        int start = (int) 'a';
        for(int i = 0; i < 26;i++){
            mapper.put((char) start,i);
            //System.out.println(start);
            start++;
        }
        
        int start2 =  (int) 'a';
        for(int i = 0; i < 26;i++){
            index_mapper.put(i,(char) start2);
            start2++;
        }
        
        for(int i = 0; i < S.length(); i++){
            chars[i] = S.charAt(i);
        }
        
        long[] sum_list = new long[shifts.length];
        sum_list[sum_list.length - 1] = shifts[shifts.length-1];
        if(shifts.length > 1){
            for(int i = sum_list.length - 2; i >= 0; i--){
                sum_list[i] = sum_list[i+1] + shifts[i];
            }
        }
        for(int i = 0; i < sum_list.length; i++){
            System.out.println(sum_list[i]);
        }
        
        for(int i = 0; i < chars.length; i++){
           
           long sum = mapper.get(chars[i]) + sum_list[i];
            if(sum < 26){
                //System.out.println(sum);
                chars[i] = index_mapper.get((int) sum);
            }else{
                long new_sum = sum % 26;
                chars[i] = index_mapper.get((int) new_sum);
            }
            
        }
       
        String res = "";
        for(int i = 0; i < chars.length; i++){
            res += chars[i];
        }
        return res;
    }
}