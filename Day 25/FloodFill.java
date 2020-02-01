import java.util.ArrayList;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        CStack stack = new CStack();
        int original = image[sr][sc];
        ArrayList<ArrayList<Integer>> seen = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> coordinate = new ArrayList<Integer>();
        coordinate.add(sr);
        coordinate.add(sc);
        stack.push(coordinate);
        while(!stack.isEmpty()){
            ArrayList<Integer> crd = stack.pop();
            //System.out.println("Popped " + crd.get(0) + " : "+ crd.get(1));
            //System.out.println((crd.get(0)-1)+","+(crd.get(0)+1)+","+(crd.get(1)-1)+","+(crd.get(1)+1));
            
                //check for left neighbour
                if(crd.get(1)-1 >= 0){
                    //System.out.println("I'm in left");
                    ArrayList<Integer> left_coordinate = new ArrayList<Integer>();
                    left_coordinate.add(crd.get(0));
                    left_coordinate.add(crd.get(1)-1);
                    if(!seen.contains(left_coordinate)){
                        if(image[crd.get(0)][crd.get(1)-1] ==  original){
                           
                            //System.out.println("left "+(crd.get(0))+":"+(crd.get(1)-1));
                            image[crd.get(0)][crd.get(1)-1] = newColor;
                            stack.push(left_coordinate);
                            //System.out.println("P : "+ left_coordinate.get(0)+" : " + left_coordinate.get(1));
                            seen.add(left_coordinate);
                        }
                    }
                }
            //check for right neighbour
                if(crd.get(1)+1 < image[crd.get(0)].length){
                    //System.out.println("I'm in right");
                    ArrayList<Integer> right_coordinate = new ArrayList<Integer>();
                    right_coordinate.add(crd.get(0));
                    right_coordinate.add(crd.get(1)+1);
                    if(!seen.contains(right_coordinate)){
                        if(image[crd.get(0)][crd.get(1)+1] ==  original){
                            
                            //System.out.println("right "+(crd.get(0))+":"+(crd.get(1)+1));
                            image[crd.get(0)][crd.get(1)+1] = newColor;
                            stack.push(right_coordinate);
                            //System.out.println("P : "+ right_coordinate.get(0)+" : "+right_coordinate.get(1));
                            seen.add(right_coordinate);
                        }
                    }
                            
                }
                //check for top neighbour 
                if(crd.get(0)-1 >= 0){
                    //System.out.println("I'm in top");
                    ArrayList<Integer> top_coordinate = new ArrayList<Integer>();
                    top_coordinate.add(crd.get(0)-1);
                    top_coordinate.add(crd.get(1));
                    if(!seen.contains(top_coordinate)){
                        if(image[crd.get(0)-1][crd.get(1)] ==  original){
                            
                            //System.out.println("top "+(crd.get(0)-1)+":"+(crd.get(1)));
                            image[crd.get(0)-1][crd.get(1)] = newColor;
                            stack.push(top_coordinate);
                            //System.out.println("P :"+ top_coordinate.get(0)+" : "+top_coordinate.get(1));

                        }
                        seen.add(top_coordinate);
                    }
                }
                //check for bottom neighbour
                if(crd.get(0)+1 < image.length){
                    //System.out.println("I'm in bottom");
                    ArrayList<Integer> bottom_coordinate = new ArrayList<Integer>();
                    bottom_coordinate.add(crd.get(0)+1);
                    bottom_coordinate.add(crd.get(1));
                    if(!seen.contains(bottom_coordinate)){
                    if(image[crd.get(0)+1][crd.get(1)] ==  original){
                        
                        //System.out.println("bottom "+(crd.get(0)+1)+":"+(crd.get(1)));
                        image[crd.get(0)+1][crd.get(1)] = newColor;
                        stack.push(bottom_coordinate);
                        //System.out.println("P :"+ bottom_coordinate.get(0)+" : "+bottom_coordinate.get(1));
                      
                        seen.add(bottom_coordinate);
                    }
                    }
                    

                }
                
            
           
        }
        image[sr][sc] = newColor;
        return image;
        
    }
}
//Custom stack
class CStack{
    ArrayList<ArrayList<Integer>> stack;
    public CStack(){
        stack = new ArrayList<ArrayList<Integer>>();
    }
    public ArrayList<Integer> pop(){
        ArrayList<Integer> num = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return num;
    }
    public void push(ArrayList<Integer> c){
        stack.add(c);
    }
    public ArrayList<Integer> peek(){
        ArrayList<Integer> num = stack.get(stack.size() - 1);
        return num;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
   
}