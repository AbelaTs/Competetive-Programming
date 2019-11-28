

public class PrefixCalculator{
    public static void calculate(String input){
    int[] input_nums = new int[input.length()];
    int operator_counter = 0;
    int nu_counter = 0;
    int op_counter = 0;
    int num_counter = 0;
    int[] result = new int[input.length()];
    for(int x=0; x < input.length(); x++){
        if(Character.isDigit(input.charAt(x))){
            num_counter++;
        }
    }
    Character[] operators = new Character[input.length()- num_counter];
    Character[] nums = new Character[num_counter];

    for(int x=0; x < input.length(); x++){
        if(Character.isDigit(input.charAt(x))){
            nums[nu_counter] = input.charAt(x);
            nu_counter++;
            // if(x-2 >= 0){
            // if(Character.isDigit(input.charAt(x-2)) && Character.isDigit(input.charAt(x-1))){
            //     operators[op_counter] = '0';
            //     op_counter++;
            // }
        }else{
            operators[op_counter] = input.charAt(x);
            op_counter++;
            
        }
    }
    
    String final_s = "";
    int o_counter = 0;
    int n_counter =0;
    
    for
    ArrayUtils.reverse(operators);

    for(int j = 0; j<num_counter; j++){
        if(o_counter < operators.length){
        final_s += nums[n_counter] +""+ operators[o_counter];
        }else{
            final_s += nums[n_counter];
         
        }
        n_counter++;
        o_counter++;
       
    }


        System.out.println(final_s);
}


   
    
    public static void main(String args[]){
        calculate("-+*45310");
    }
}