//https://leetcode.com/problems/largest-perimeter-triangle/
import java.util.Arrays;
class LargestPerimeter {
    public static int largestPerimeter(int[] A) {
        int perimeter = 0;
        double area;
       //sorting the list in increasing order
        for(int i = 1; i<A.length; i++){
            int counter = i;
            while(counter > 0){
                if(A[counter] > A[counter - 1]){
                    int temp = A[counter - 1];
                    A[counter-1] = A[counter];
                    A[counter] = temp;
                    counter--;
                }else{
                    break;
                }
            }
        }        
        if(A.length < 3){
            return 0;
        }else{
                int pointer = 0;
                int[] sample;
                while(pointer + 3 <= A.length){
                    System.out.println("P :"+pointer);
                    sample = Arrays.copyOfRange(A,pointer,pointer+3);
                    
                    if(checkTriangle(sample)){
                    
                        area = 0.5*sample[sample.length -1]*sample[sample.length -2];
                        
                        if(area >= 1){
                            perimeter = sample[0] + sample[1] + sample[2];
                            return perimeter;
                        }
                    }
                    pointer++;
            }
                
        }
       return perimeter;
        
    }
    //check if the sides are valid for triangle
    public static boolean checkTriangle(int[] sizes){
        if(sizes[0] < sizes[1] + sizes[sizes.length - 1]){
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        int[] list = {3,2,3,4};
        System.out.println(largestPerimeter(list));
    }
}