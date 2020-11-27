class Solution {
    public String thousandSeparator(int n) {
        String numString = Integer.toString(n);
        StringBuilder result = new StringBuilder();
        for(int index = 0; index < numString.length(); index++){
            int pointer = numString.length() - index;
            if(pointer % 3 == 0 && index != 0){
                result.append(".");
                result.append(String.valueOf(numString.charAt(index)));
            }else{
                result.append(String.valueOf(numString.charAt(index)));
            }     
        }
        System.out.println(result.toString());
        return result.toString();
        
    }
}