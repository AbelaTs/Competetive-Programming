//Not finished yet
import java.io.*; 
import java.util.*; 
class DistantBarcode{
    public static int[] rearrangeBarcodes(int[] barcodes) {
        ArrayList<Integer> barcode = new ArrayList<Integer>();
        CStack result = new CStack();
        int[] final_result = new int[barcodes.length];
        int

        for(int i = 0; i<barcodes.length; i++){
            barcode.add(barcodes[i]);
        }
        int counter = 0;

        while(!barcode.isEmpty()){
            if(result.isEmpty()){
                result.push(barcode.get(counter));
                barcode.remove(counter);
            }else if(result.peek() != barcode.get(counter)){
                result.push(barcode.get(counter));
                barcode.remove(counter);
                counter = 0;
            }else{
                
                counter++;
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