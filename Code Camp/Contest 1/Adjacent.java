import java.util.ArrayList;

public class Adjacent {
    public String removeDuplicates(String s, int k) {
        Character[] crs = new Character[s.length()];
        CStack stack = new CStack();
        for(int i = 0; i < s.length(); i++){
            crs[i] = s.charAt(i);
        }
        //remove duplicates using stack
        for(int i = s.length()-1; i >= 0;i--){
            Node node = new Node(crs[i],1);
            if(!stack.isEmpty()){
                Node nde = stack.peek();
                if(nde.getChar() == crs[i]){
                    nde.increaseCount();
                    if(nde.getCount() == k){
                        stack.pop();
                    }
                }else{
                    stack.push(node);
                 }
            }else{
                stack.push(node);
            }
        }
        //
        String res = "";
        while(!stack.isEmpty()){
            Node node = stack.pop();
            for(int i = 0; i < node.getCount(); i++){
                 res += Character.toString(node.getChar());
            }
        }
        return res;

       

    }
}
class Node{
    static char character;
    static int count;
    public Node(char cr,int cnt){
            character = cr;
            count = cnt;
        }
    public char getChar(){
        return character;    
    }
    public int getCount(){
        return count;
    }
    public void increaseCount(){
        count++;
    }
}
//Custom stack
class CStack{
    ArrayList<Node> stack;
    public CStack(){
        stack = new ArrayList<Node>();
    }
    public Node pop(){
        Node num = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return num;
    }
    public void push(Node c){
        stack.add(c);
    }
    public Node peek(){
        Node num =  stack.get(stack.size() - 1);
        return num;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void addFirst(int num){
        
    }
}
        