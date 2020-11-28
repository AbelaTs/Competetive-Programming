class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n-1,n,"(",result);
        return result;
        
    }
    public void generate(int opening,int closing,String passed,List<String> result){
        //if we are done 
        if(opening == 0 && closing == 0){
            result.add(passed);
            return;
        }
        //if we are done looking for opening bracket
        if(opening == 0 && closing > 0 ){
            generate(opening,closing-1,passed+")",result);
            return;
        }
        //if opening brackets are more than closing
        if(opening > closing){
            return;
        }
        generate(opening-1,closing,passed + "(",result);
        generate(opening,closing-1,passed+")",result);
    }
}