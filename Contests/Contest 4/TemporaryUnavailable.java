import java.util.Scanner;
public class TemporaryUnavailable{
    public static int getIntersectionLength(int s1, int e1, int s2, int e2){
        int dis = Math.min(e1, e2) - Math.max(s1, s2);
        if(e1 < s2 || e2 < s1){
            dis = 0;
        }
       
       
        return e1 - s1 -dis;

    }
     
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int iterator = scanner.nextInt();
        scanner.nextLine();
        int[] result = new int[iterator];
        int counter = 0;
      
        while(iterator > 0){
            
            String input = scanner.nextLine();
            String[] in = input.split(" ");
            int[] nums = new int[in.length];
            for(int i = 0; i<in.length; i++ ){
                nums[i] = Integer.parseInt(in[i]);
            }
            int larger = nums[0];
            int min = nums[1];
            if(nums[0] < nums[1]){
                larger = nums[1];
                min = nums[0];
            }
            result[counter] = getIntersectionLength(min,larger,nums[2]-nums[3],nums[2] + nums[3]);
            counter++;
            iterator--;
        }
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}