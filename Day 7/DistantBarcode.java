//Not finished yet
import java.io.*; 
import java.util.*; 
class DistantBarcode{
    public static int[] rearrangeBarcodes(int[] barcodes) {
        ArrayList<Integer> barcode = new ArrayList<Integer>();
        int[] final_result = new int[barcodes.length];
        CStack result = new CStack();
        
        
        //adding  members to the arraylist
        for(int i = 0; i<barcodes.length; i++){
            barcode.add(barcodes[i]);
            
          
        }
        
        //Rearranging the numbers and adding to the final result
        int count = 0;

        while(!barcode.isEmpty()){
           // if(count ==  barcode.size()){
           //      count = 0;
           //  }
            if(result.isEmpty()){
                result.push(barcode.get(count));
                barcode.remove(count);
               
            }else if(result.peek() != barcode.get(count)){
               
                result.push(barcode.get(count));
                barcode.remove(count);
                 count=0;
            }else if(result.peek() == barcode.get(count)){
                if(barcode.size() == 1){
                   
                     result.addFirst(barcode.get(count));
                     barcode.remove(count);
                }else{
                count++;
                }
            }
             
        }
        //putting the result into the final array
        for(int i=0; i<final_result.length;i++){
            final_result[i] = result.pop();
        }



        return final_result;
    }
    public static void main(String args[]){
        int[] list = {2,1,1};
        list = rearrangeBarcodes(list);
        for(int i=0; i<list.length;i++){
            System.out.println(list[i]);
        }

    }

}
//Custom stack
class CStack{
    ArrayList<Integer> stack;
    public CStack(){
        stack = new ArrayList<Integer>();
    }
    public int pop(){
        int num = (int) stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return num;
    }
    public void push(int c){
        stack.add(c);
    }
    public int peek(){
        int num = (int) stack.get(stack.size() - 1);
        return num;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void addFirst(int num){
        
    }
}