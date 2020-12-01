//https://leetcode.com/problems/word-search-ii/
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        HashSet<String> seen = new HashSet<>();
        for(int index = 0; index < words.length; index++){
            trie.insert(words[index]);
        }
        List<String> result = new ArrayList<>();
        String stringResult = "";
        for(int row = 0; row <  board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(trie.getTrie().children.containsKey(board[row][col])){
                    goDFS(board,row,col,result,trie.getTrie(),stringResult,seen);
                }
            }
        }
        return result;
    }
    public void goDFS(char[][] board,int row,int col,List<String> result,TrieNode trieNode,String resultString,HashSet<String> seen){
        resultString += board[row][col];
        seen.add(row+","+col);
        if(trieNode.children.get(board[row][col]).endOfWord && !result.contains(resultString)){
                result.add(resultString);      
            //System.out.println(resultString);
        }
       // System.out.println(resultString.toString());
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int index = 0; index < directions.length; index++){
            int newRow = row + directions[index][0];
            int newCol = col + directions[index][1];
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[newRow].length && trieNode.children.get(board[row][col]).children.containsKey(board[newRow][newCol]) && !seen.contains(newRow+","+newCol)){
                goDFS(board,newRow,newCol,result,trieNode.children.get(board[row][col]),resultString,seen);
            }
       }
        seen.remove(row+","+col);
    }
}
class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean endOfWord;
    public TrieNode(){
        children = new HashMap<>();
        endOfWord = false;
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public TrieNode getTrie(){
        return root;
    }
    //inserting to trieNode
    public void insert(String Word){
        TrieNode tempRoot = root;
        for(int index = 0; index < Word.length(); index++){
            char letter = Word.charAt(index);
            if(!tempRoot.children.containsKey(letter)){
                tempRoot.children.put(letter,new TrieNode());
            }
            tempRoot = tempRoot.children.get(letter);
        }
        tempRoot.endOfWord = true;
    }
    //searching in trieNode
    public boolean search(String word){
        TrieNode tempRoot = root;
        for(int index = 0; index <  word.length(); index++){
            char letter = word.charAt(index);
            if(!tempRoot.children.containsKey(letter)){
                return false;
            }
            tempRoot = tempRoot.children.get(letter);
        }
        return tempRoot.endOfWord;
    }
}
