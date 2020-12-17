//https://leetcode.com/problems/satisfiability-of-equality-equations/
class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] charArray = new int[26];
        Arrays.fill(charArray,-1);
        //building the union list 
        for(String equation : equations){
            int firstChar = equation.charAt(0) - 'a';
            int secondChar = equation.charAt(3) - 'a';
            if(equation.charAt(1) == '='){
                union(charArray,firstChar,secondChar);
            }
        }
       // System.out.println(Arrays.toString(charArray));
        //checking if there is wrong statement
        for(String equation : equations){
            int firstChar = equation.charAt(0) - 'a';
            int secondChar = equation.charAt(3) - 'a';
            if(equation.charAt(1) == '!'){
                int char1Root = find(charArray, firstChar);
                int char2Root = find(charArray, secondChar);
                if(char1Root == char2Root && char1Root != -1){
                    return false;
                }else if(firstChar == secondChar){
                    return false;
                }
            }
        }
        return true;
        
    }
    public void union(int[] roots, int char1, int char2){
        if(roots[char1] == -1 && roots[char2] == -1){
            roots[char1] = char1;
            roots[char2] = char1;
        }else if(roots[char1] == -1 && roots[char2] != -1){
            int root = find(roots,char2);
            roots[char1] = root;
        }else if(roots[char2] == -1 && roots[char1] != -1){
           int root = find(roots,char1);
            roots[char2] = root; 
        }else{
            int root1 = find(roots,char1);
            int root2 = find(roots,char2);
            roots[char2] = root1;
            roots[root2] = root1;
        }
    }
    
    public int find(int[] roots, int char2){
        if(roots[char2] == char2){
            return char2;
        }
        if(roots[char2] == -1){
            return -1;
        }
        return find(roots,roots[char2]);
    }
}