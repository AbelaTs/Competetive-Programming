import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class MovingStones {
    public int removeStones(int[][] stones) {
        HashMap<Integer,ArrayList<Coordinate>> row_mapper = new HashMap<Integer,ArrayList<Coordinate>>();
        HashMap<Integer,ArrayList<Coordinate>> col_mapper = new HashMap<Integer,ArrayList<Coordinate>>();
        HashSet<Coordinate> seen = new HashSet<Coordinate>();
        int stone_counter = 0;
        CStack stack = new CStack();
        //mapping each coordinate with its row and column neighbours
        for( int  i = 0; i < stones.length; i++){
            //add row neighbours
            if(row_mapper.containsKey(stones[i][0])){
                row_mapper.get(stones[i][0]).add(new Coordinate(stones[i][0],stones[i][1]));
            }else{
                ArrayList<Coordinate> new_one = new ArrayList<Coordinate>();
                new_one.add(new Coordinate(stones[i][0],stones[i][1]));
                row_mapper.put(stones[i][0],new_one);
            }
            //add column neighbours
            if(col_mapper.containsKey(stones[i][1])){ 
                col_mapper.get(stones[i][1]).add(new Coordinate(stones[i][0],stones[i][1]));
            }else{
                ArrayList<Coordinate> new_one = new ArrayList<Coordinate>();
                new_one.add(new Coordinate(stones[i][0],stones[i][1]));
                col_mapper.put(stones[i][1],new_one);
            }
            
            
        }
        
        for(int i = 0; i < stones.length; i++){
            Coordinate coor = new Coordinate(stones[i][0],stones[i][1]);
            //if it already has been visited jump it
            if(seen.contains(coor)){
                continue;
            }
            stack.push(coor);
            while(!stack.isEmpty()){
                Coordinate c = stack.pop();
                seen.add(c);
                ArrayList<Coordinate> neighbours = new ArrayList<Coordinate>(); 
                neighbours.addAll(row_mapper.get(c.row));
                neighbours.addAll(col_mapper.get(c.column));
                
                //counting paths along its row neighbours
                for(Coordinate crd : neighbours){
                    if(!seen.contains(crd)){
                        stack.push(crd);
                        seen.add(crd);
                        stone_counter++;
                    }
                }
                
                
            }
        }
        
      return stone_counter;  
    }
}
//
class Coordinate {
    int row;
    int column;

    public Coordinate(int givenR, int givenC) {
        row = givenR;
        column = givenC;
    }

    @Override
    public boolean equals(Object o){
        Coordinate newCoordinate = (Coordinate) o;
        return this.row == newCoordinate.row && this.column == newCoordinate.column;
    }

    @Override
    public int hashCode() {
        String hash = ""+ row + column;
        return hash.hashCode();
    }
}
//Custom stack
class CStack{
    ArrayList<Coordinate> stack;
    public CStack(){
        stack = new ArrayList<Coordinate>();
    }
    public Coordinate pop(){
        Coordinate num = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return num;
    }
    public void push(Coordinate c){
        stack.add(c);
    }
    public Coordinate peek(){
        Coordinate num = stack.get(stack.size() - 1);
        return num;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void addFirst(ArrayList<Integer> num){
        
    }
}