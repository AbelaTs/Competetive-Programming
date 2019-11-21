//Author : Abel Tsegaye
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


char reversed_num1[1000000];
char reversed_num2[1000000];
char result[10000000];
char reversed_result[10000000];
char unsigned_num1[1000000];
char unsigned_num2[1000000];
char temp_res[10000000];
char signed_res[10000000];
char larger_num[1000000];
char smaller_num[1000000];

void reverse_number(char num_to_reverse[], char reverse_store[]);
void calculate_sum(char rev_num1[],char rev_num2[],char temporary_result[],char real_result[]);
void equalize_num(char lar_number[],char small_number[]);
void calculate_negation(char larger_num[],char smaller_num[],char temporary_result[],char real_result[]);
void remove_sign(char num[],char new_num[]);
void removePreZeros(char num[],char res[]);
void addSign(char num[],char res[]);
void compare(char num1[],char num2[],char larger_num[],char smaller_num[]);
void calculator(char num1[],char num2[]);

//Reverses the input numbers
void reverse_number(char num_to_reverse[], char reverse_store[]){
       //reversing the numbers
    int x = 0;
    for (int i = strlen(num_to_reverse)-1; i >= 0; i--)
    {
          
        reverse_store[x] = num_to_reverse[i];
        
        x++;
       
    }
}

//Calculates the result
void calculate_sum(char rev_num1[],char rev_num2[],char temporary_result[],char real_result[]){
    int hold = 0;
    int temp_result = 0;
     //Calculate result
    for (int i = 0; i < strlen(rev_num1); i++)
    {
        int dig1 = rev_num1[i] - '0';
        int dig2 = rev_num2[i] - '0';
        temp_result =  dig1 + dig2 + hold;
        if (temp_result >= 10)
        {
          if (rev_num1[i+1] == '\0')
          {
              hold = 1;
              temp_result = temp_result - 10;
              temporary_result[i] = temp_result + '0';
              temporary_result[i+1] = hold + '0';
          }else{
               hold = 1;
               temp_result = temp_result - 10;
              temporary_result[i] = temp_result + '0';
          }
          
       
            
        }else{
            hold = 0;
          temporary_result[i] = temp_result + '0';
        }
    }
    
    reverse_number(temporary_result,real_result);
  
    
}

//method to equalize two unequal numbers with different number of digits
void equalize_num(char lar_number[],char small_number[]){
    for (int count = 0; count < strlen(lar_number); count++)
    {
      if (small_number[count] == '\0')
      {
        small_number[count] = '0';
      }
      
    }
    
}



//Calculates the negation
void calculate_negation(char larger_num[],char smaller_num[],char temporary_result[],char real_result[]){
    int temp_difference = 0;
    int next_int = larger_num[0] - '0';// represents each number in larger number which is used to trace dept
    int dig2;
     //Calculate difference
    for (int i = 0; i < strlen(larger_num); i++)
    {
        dig2 = smaller_num[i] -'0';
        if (larger_num[i] == '\0')
        {
           break;
        }
        else if(next_int >= 0)
        {
            if (next_int >= dig2)
            {
                temp_difference = next_int - dig2;
                temporary_result[i] = temp_difference + '0'; //converting result back to char
                next_int = larger_num[i+1] - '0';
            }else{
                temp_difference = next_int+10 - dig2; //borrowing one from the neighboor
                temporary_result[i] = temp_difference + '0';
                next_int = larger_num[i+1] -'0';
                next_int = next_int -1;
            }
            
        }
        //If the next number or dept is negative
        else{
            next_int = next_int +10;
            temp_difference = next_int - dig2;
            temporary_result[i] = temp_difference + '0';
            next_int = larger_num[i+1] - '0';
            next_int = next_int - 1;

        }
        
    }
    reverse_number(temporary_result,real_result);
    

    
    
    
}

//method to remove the - sign from numbers
void remove_sign(char num[],char new_num[]){
    int pointer = 0;
     
    for (int i = 1; i < strlen(num); i++)
    {
          
        new_num[pointer] = num[i];
        pointer++;
      
       
    }
   

}
//method ot remove zeros coming at front 
void removePreZeros(char num[],char res[]){
    int current_pointer = 0;
    int finalResult_pointer = 0;
    for (int i = 0; i < strlen(num); i++)
    {
        if (num[i] != '0')
        {
           break;
        }
        current_pointer++;
        
        
        
    }

    for (int i = current_pointer; i < strlen(num); i++)
    {
        res[finalResult_pointer] = num[i];
        finalResult_pointer++;
    }
    
 
    

    
    
}
//method to add the - sign on results
void addSign(char num[],char res[]){
    int x = 0;
    res[0] = '-';
    for (int i = 1; i <= strlen(num); i++)
    {
       res[i] = num[x];
       x++; 
    }
    
}

//method to compare two integers
void compare(char num1[],char num2[],char larger_num[],char smaller_num[]){
   
   
    if (strlen(num1) > strlen(num2))
    {
        for (int i = 0; i < strlen(num1); i++)
        {
            larger_num[i] = num1[i];
        }
        for (int i = 0; i < strlen(num2); i++)
        {
            smaller_num[i] = num2[i];
        }
        
       
        
    }else if(strlen(num1)== strlen(num2))
    {
        
        for (int i = 0; i < strlen(num1); i++)
        {
            int num_one = num1[i] - '0';
            int num_two = num2[i] - '0';

            if (num_one > num_two)
            {
                 for (int i = 0; i < strlen(num1); i++)
                    {
                        larger_num[i] = num1[i];
                    }
                 for (int i = 0; i < strlen(num2); i++)
                    {
                        smaller_num[i] = num2[i];
                    }
        

                break;
            }else if(num_two > num_one){
                for (int i = 0; i < strlen(num1); i++)
                    {
                        larger_num[i] = num2[i];
                    }
                 for (int i = 0; i < strlen(num2); i++)
                    {
                        smaller_num[i] = num1[i];
                    }
                break;
            }
            
        }
       
        
        
    }else{
        for (int i = 0; i < strlen(num1); i++)
            {
              larger_num[i] = num2[i];
            }
        for (int i = 0; i < strlen(num2); i++)
            {
                smaller_num[i] = num1[i];
            }
    }
    
    
    
}





//Two integer adders
void calculator(char num1[],char num2[]){

    //If both numbers have equal size 
    if(strlen(num1) ==  strlen(num2)){

    //if both of the numbers are negative
        if (num1[0] =='-' && num2[0] =='-' )
        {
            remove_sign(num1,unsigned_num1);
            remove_sign(num2,unsigned_num2);
            reverse_number(unsigned_num1,reversed_num1);
            reverse_number(unsigned_num2,reversed_num2);
            //Calculate result
            calculate_sum(reversed_num1,reversed_num2,reversed_result,result); 
            addSign(result,signed_res);
            printf("Answer : %s \n",signed_res);

        }else if (num1[0] == '-')//if first entry is negative and second entry is posetive
        {
           
          remove_sign(num1,unsigned_num1);//Remove the negative sign
          
          reverse_number(unsigned_num1,reversed_num1);
          
          reverse_number(num2,reversed_num2);
          
          equalize_num(reversed_num2,reversed_num1);
         
          calculate_negation(reversed_num2,reversed_num1,reversed_result,result);

          removePreZeros(result,temp_res);//Remove all zeros coming at front

          printf("Answer : %s \n",temp_res);

         
        }else if(num2[0] == '-')//if first entry is posetive and second entry is negative
        {
          remove_sign(num2,unsigned_num2);//Remove the negative sign
          
          reverse_number(unsigned_num2,reversed_num2);
          
          reverse_number(num1,reversed_num1);
          
          equalize_num(reversed_num1,reversed_num2);//Equalizing the digits
         
          calculate_negation(reversed_num1,reversed_num2,reversed_result,result);

          removePreZeros(result,temp_res);//Remove all zeros coming at front

          printf("Answer : %s \n",temp_res);

        }
        else{
        
        
        
        //reversing the numbers
        reverse_number(num1,reversed_num1);
        

        reverse_number(num2,reversed_num2);

        //Calculate result
        calculate_sum(reversed_num1,reversed_num2,reversed_result,result);  
        printf("Answer : %s \n",result);

        }
        
        }
        //If they dont have the same size
    else{
        if (strlen(num1) > strlen(num2))
        {
            //Checking the either of the numbers are negative
            if (num1[0] == '-')
            {
                    
                remove_sign(num1,unsigned_num1);//Remove the negative sign
                reverse_number(unsigned_num1,reversed_num1);
                reverse_number(num2,reversed_num2);
                    //if their size isnot equal which means the negative is larger
                    if (strlen(reversed_num1) != strlen(reversed_num2))
                    {
                        equalize_num(reversed_num1,reversed_num2); //Equalizing the digits
                        calculate_negation(reversed_num1,reversed_num2,reversed_result,result);
                        removePreZeros(result,temp_res);//Remove all zeros coming at front
                        addSign(temp_res,signed_res);//Adding the negative sign
                        printf("Answer : %s \n", signed_res); 
                    }
                    // if their size is equal without the sign we have to compare them first to know which one is larger
                    else{
                        
                        compare(unsigned_num1,num2,larger_num,smaller_num);//compares which one is larger number
                        
                        reverse_number(larger_num,reversed_num1);//reverses the larger number and place it in reversed_num1 variable
                        reverse_number(smaller_num,reversed_num2);//reverses the smaller number and place it in reversed_num2 variable
                        calculate_negation(reversed_num1,reversed_num2,reversed_result,result);
                    
                        removePreZeros(result,temp_res);
                        
                        if (strcmp(larger_num,unsigned_num1) == 0) // if the negative number is greater than the posetive number
                        {
                        addSign(temp_res,signed_res);
                        printf("Answer : %s\n",signed_res);
                        }else
                        {
                            
                            printf("Answer : %s\n",temp_res);
                        }
                        
                        
                    }
                    

                
              
            }else if (num2[0] == '-')
            {
                remove_sign(num2,unsigned_num2);//Remove the negative sign
                reverse_number(unsigned_num2,reversed_num2);
                reverse_number(num1,reversed_num1);
                equalize_num(reversed_num1,reversed_num2);//Equalize the digit
                calculate_negation(reversed_num1,reversed_num2,reversed_result,result);
                printf("Answer : %s \n",result);
            }
            //If non of them is negative
            else{
                //reversing the numbers
            reverse_number(num1,reversed_num1);
        

            reverse_number(num2,reversed_num2);
            //equalizing the digits first
            equalize_num(reversed_num1,reversed_num2);


            //Calculate result
            calculate_sum(reversed_num1,reversed_num2,reversed_result,result); 

            printf("Answer : %s \n",result); 
            }
            
                    
        
    }
    //If the second number has the greater size
    else{
            //Checking the either of the numbers are negative
            if (num2[0] == '-')
            {
                    
                remove_sign(num2,unsigned_num2);
                
                reverse_number(unsigned_num2,reversed_num2);
                reverse_number(num1,reversed_num1);
                if (strlen(reversed_num2) != strlen(reversed_num1))// Means the negative number is larger
                {
                    calculate_negation(reversed_num2,reversed_num1,reversed_result,result);  
                    removePreZeros(result,temp_res);
                    addSign(temp_res,signed_res);
                    printf("Answer : %s \n",signed_res);
                }else{
                        compare(unsigned_num2,num1,larger_num,smaller_num);//compares which one is larger number
                        
                        reverse_number(larger_num,reversed_num1);//reverses the larger number and place it in reversed_num1 variable
                        reverse_number(smaller_num,reversed_num2);//reverses the smaller number and place it in reversed_num2 variable
                        calculate_negation(reversed_num1,reversed_num2,reversed_result,result);
                        removePreZeros(result,temp_res);
                        if (strcmp(larger_num,unsigned_num2) == 0) // if the negative number is greater than the posetive number
                        {
                           
                          addSign(temp_res,signed_res);
                          printf("Answer : %s\n",signed_res);
                        }else
                        {
                         
                        printf("Answer : %s\n",temp_res);
                        }

                }         
            }
            else if (num1[0] == '-')
                    {
                        remove_sign(num1,unsigned_num1);
                        reverse_number(unsigned_num1,reversed_num1);
                        reverse_number(num2,reversed_num2);
                        equalize_num(reversed_num2,reversed_num1);
                        calculate_negation(reversed_num2,reversed_num1,reversed_result,result);
                        printf("Answer : %s \n",result);
                }
            //If non of them is negative
            else{
            //reversing the numbers
            reverse_number(num1,reversed_num1);
        

            reverse_number(num2,reversed_num2);

            //equalizing the digits first
        equalize_num(reversed_num2,reversed_num1);

            //Calculate result
            calculate_sum(reversed_num1,reversed_num2,reversed_result,result);
            printf("Answer : %s \n",result);  
            }
        }
        

        }
}


int main(){
    char num1[1000000];
    printf("Hello. Please enter your first number?\n");
    scanf("%s", &num1);
    char num2[1000000];
    printf("Please enter your second number?\n");
    scanf("%s", &num2);
    calculator(num1,num2);
   
   
   return 0;
   


   
}



