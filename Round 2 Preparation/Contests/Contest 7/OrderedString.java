import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-215/problems/design-an-ordered-stream/
class OrderedStream {
    String[] valueList;
    int pointer;

    public OrderedStream(int n) {
        valueList = new String[n];
        pointer = 0;
    }
    
    public List<String> insert(int id, String value) {
        ArrayList<String> stringArray = new ArrayList<>();
        if(pointer == id-1){
            valueList[id-1] = value;
            for(int index = pointer; index <  valueList.length; index++){
                if(valueList[index] != null){
                  stringArray.add(valueList[index]);
                  pointer = index;
                  continue;
                }
                pointer = index;
                break;           
            }
        }else{
            valueList[id-1] = value;
        }
        return stringArray;        
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */