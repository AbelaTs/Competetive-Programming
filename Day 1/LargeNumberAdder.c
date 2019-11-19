#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char reversed_num1[1000000];
char reversed_num2[1000000];
char sum[10000000];
char reversed_sum[10000000];
char large_num[1000000];
void calculate_sum(char rev_num1[],char rev_num2[],char temporary_sum[],char real_sum[]);
void reverse_number(char num_to_reverse[], char reverse_store[]);
void equalize_num(char lar_number[],char small_number[]);
void calculate_negation(char rev_num1[],char rev_num2[],char temporary_sum[],char real_sum[]);
void adder(char num1[],char num2[])

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

//Calculates the sum
void calculate_sum(char rev_num1[],char rev_num2[],char temporary_sum[],char real_sum[]){
    int hold = 0;
    int temp_sum = 0;
     //Calculate sum
    for (int i = 0; i < strlen(reversed_num1); i++)
    {
        int dig1 = rev_num1[i] - '0';
        int dig2 = rev_num2[i] - '0';
        temp_sum =  dig1 + dig2 + hold;
        if (temp_sum >= 10)
        {
          if (reversed_num1[i+1] == '\0')
          {
              hold = 1;
              temp_sum = temp_sum - 10;
              temporary_sum[i] = temp_sum + '0';
              temporary_sum[i+1] = hold + '0';
          }else{
               hold = 1;
               temp_sum = temp_sum - 10;
              temporary_sum[i] = temp_sum + '0';
          }
          
       
            
        }else{
          temporary_sum[i] = temp_sum + '0';
        }
    }
    
    reverse_number(temporary_sum,real_sum);
    printf("%s \n",real_sum);
}

//Equalises digits
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
void calculate_negation(char rev_num1[],char rev_num2[],char temporary_sum[],char real_sum[]){
    int temp_difference = 0;
     //Calculate sum
    for (int i = 0; i < strlen(reversed_num1); i++)
    {
        int dig1 = rev_num1[i] - '0';
        int dig2 = rev_num2[i] - '0';
       
        if (dig1 > dig2)
        {
              temp_difference =  dig1 - dig2;
              temporary_sum[i] = temp_difference + '0';    
        }else{
          int next_num = reversed_num1[i+1] -'0';
          next_num = next_num - 1;
          reversed_num1[i+1] = next_num + '0';
          temp_difference =  dig2 - dig1;
          temporary_sum[i] = temp_difference + '0';
        }
    }
    
    reverse_number(temporary_sum,real_sum);
    printf("%s \n",real_sum);
}





//Two integer adders
void adder(char num1[],char num2[]){

    
    if(strlen(num1) ==  strlen(num2)){


    
    
    //reversing the numbers
    reverse_number(num1,reversed_num1);
    

    reverse_number(num2,reversed_num2);

    //Calculate sum
    calculate_sum(reversed_num1,reversed_num2,reversed_sum,sum);  
    
    }else{
      if (strlen(num1) > strlen(num2))
      {
                 
        //reversing the numbers
           reverse_number(num1,reversed_num1);
    

           reverse_number(num2,reversed_num2);
        //equalizing the digits first
           equalize_num(reversed_num1,reversed_num2);


        //Calculate sum
           calculate_sum(reversed_num1,reversed_num2,reversed_sum,sum);  
        

      }else{
        //reversing the numbers
        reverse_number(num1,reversed_num1);
    

        reverse_number(num2,reversed_num2);

        //equalizing the digits first
       equalize_num(reversed_num2,reversed_num1);

        //Calculate sum
        calculate_sum(reversed_num1,reversed_num2,reversed_sum,sum);  
      }
      

    }
}


int main(){
  
   adder("220","200");
   


   
}



