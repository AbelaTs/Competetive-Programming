import java.util.HashMap;

class NumberLinesWriting {
    public int[] numberOfLines(int[] widths, String S) {
        HashMap<Integer,Integer> mapper = new HashMap<Integer,Integer>();
        int start = Character.getNumericValue('a');
        
        for(int i = 0; i < widths.length; i++){
            mapper.put(start,widths[i]);
            start++;
        }
        
        int total_width = 0;
        int last_line_sum = 0;
        int line_counter = 0;
        
        for(int i = 0; i < S.length(); i++){
            if((total_width + mapper.get(Character.getNumericValue(S.charAt(i)))) - 100 > 0){
                line_counter++;
                total_width = mapper.get(Character.getNumericValue(S.charAt(i)));
            }else{
                total_width += mapper.get(Character.getNumericValue(S.charAt(i)));
            }
            
        }
        
        int[] res = new int[2];
        res[0] = line_counter+1;
        
        for(int i = S.length()-1; i >= 0; i--){
            last_line_sum += mapper.get(Character.getNumericValue(S.charAt(i)));
            total_width -= mapper.get(Character.getNumericValue(S.charAt(i)));
            if(total_width == 0){
                break;
            }
             
            
        }
        res[1] = last_line_sum;
        return res;
    }
}