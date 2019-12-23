import java.util.HashMap;
import java.util.Scanner;

public class SnowWalkingRobot{
    public static String[] getPath(String path){
        String res = "";
        int u = 0;
        int d = 0;
        int l = 0;
        int r = 0; 
        for(int i = 0; i < path.length(); i++){
            switch(path.charAt(i)){
                case 'U':
                    u++;
                    break;
                case 'D':
                    d++;
                    break;
                case 'R':
                    r++;
                    break;
                case 'L':
                    l++;
                    break;
            }
        }
        
        if(u > d){
            
            u = u - (u - d);
            
        }else if(u < d){
            d = d - (d - u);
          
        }
        
        if(r > l){
            r = r - (r - l);
            
        }else if(r < l){
            l = l - (l - r);
           
        }

        if(r > 0 && l > 0){
            if(u == 0 && d == 0){
                r = 1;
                l = 1;
            } 
        }

        if(u > 0 && d > 0){
            if(r == 0 && l == 0){
                d = 1;
                u = 1;
            }
        }
        for(int i = 0; i < d; i++){
            res+='D';
        }
        for(int i = 0; i < r; i++){
            res+='R';
        }
        for(int i = 0; i < u; i++){
            res+='U';
        }
        for(int i = 0; i < l; i++){
            res+='L';
        }
        
        String[] result = {Integer.toString(u+d+l+r),res};
        return result;
        


    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int iterator = scanner.nextInt();
        scanner.nextLine();
        String[][] result = new String[iterator][2];
        int counter = 0;
      
        while(iterator > 0){
            
            String input = scanner.nextLine();
            result[counter] = getPath(input);
            counter++;
            iterator--;
        }
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i][0]);
            System.out.println(result[i][1]);
        }
    }
}