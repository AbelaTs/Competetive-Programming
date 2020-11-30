//https://leetcode.com/contest/weekly-contest-144/problems/defanging-an-ip-address/
class Solution {
    public String defangIPaddr(String address) {
        String[] charArray = new String[address.length()];
        for(int index = 0; index <  address.length(); index++){
            if(address.charAt(index) == '.'){
                charArray[index] = "[.]";
            }else{
                charArray[index] = String.valueOf(address.charAt(index));
            }
        }
        StringBuilder result = new StringBuilder();
        for(int index = 0; index <  charArray.length; index++){
            result.append(charArray[index]);
        }
        return result.toString();
    }
}
