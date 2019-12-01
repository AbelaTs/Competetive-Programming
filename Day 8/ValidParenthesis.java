class ValidParenthesis {
    boolean found_match = false;
    public boolean isValid(String s) {
        CStack stack = new CStack();
      
        for(int i = 0;i < s.length(); i++){
            switch(s.charAt(i)){
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        char c = stack.peek();
                        if(c == '('){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }
                    break;
                    
                case ']':
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        char d = stack.peek();
                        if(d == '['){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }
                    break;
                case '}':
                     if(stack.isEmpty()){
                        return false;
                    }else{
                        char e = stack.peek();
                        if(e == '{'){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }
                    break;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    
}
//Custom stack
class CStack{
    ArrayList<Character> stack;
    public CStack(){
        stack = new ArrayList<Character>();
    }
    public char pop(){
        char character = (char) stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return character;
    }
    public void push(char c){
        stack.add(c);
    }
    public char peek(){
        char character = (char) stack.get(stack.size() - 1);
        return character;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
}