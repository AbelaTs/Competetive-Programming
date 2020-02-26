//https://leetcode.com/problems/reverse-integer/
class ReverseInteger {
    public int reverse(int x) {
        int number = x;
        if(x<0){
            number = Math.abs(x);
        }
        String num = Integer.toString(number);
        int reversed_num = 0;
        char[] chars = new char[num.length()];
       
        int count = 0;
        
        for(int i=num.length()-1; i>=0; i--){
               chars[count] = num.charAt(i); 
               count++;
            
        }
        String rev_num = new String(chars);
        try{
        if(x < 0){
            reversed_num = Integer.parseInt(rev_num);
            reversed_num = 0-reversed_num;
        } else{
            reversed_num = Integer.parseInt(rev_num);
            }
    
        }catch(NumberFormatException ex){
            
        }
        return reversed_num;
        
    }
}