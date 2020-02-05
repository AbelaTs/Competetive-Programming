import java.util.ArrayList;

class MinimumCost {
    public int mctFromLeafValues(int[] arr) {
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i <arr.length; i++){
            leaves.add(arr[i]);
        }
        int sum = 0;
        while(leaves.size() > 0){
           int min = getMin(leaves);
           int index = leaves.indexOf(min);
           if(index-1 >=0 && index + 1 < leaves.size()){
               if(leaves.get(index-1) <= leaves.get(index+1)){
                    
                   sum += (min*leaves.get(index-1));
               }else{
                   
                   sum += (min*leaves.get(index+1));
               }
           }else{
               if(index-1 >= 0){
                
                   sum += (min*leaves.get(index-1));
               }else if(index + 1 < leaves.size()){
                   sum += (min*leaves.get(index+1));
               }
           }
           leaves.remove(index);
        }
        return sum;
    }
    public int getMin(ArrayList<Integer> list){
        int min = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < min){
                min = list.get(i);
            }
        }
        return min;
    }
}