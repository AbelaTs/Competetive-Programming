//Author : Abel Tsegaye

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int indentation_counter = 0; //counts the indetation for each product
char sum[1000000000];//stores the sum of each product
char existing_product[1000000];//stores the existing product
char* temp_holder;// temporary storage
char* reversed_product; // stores the reversed form of each product 
char reversed_num1[1000000]; //stores the reversed form of the user input
char reversed_num2[1000000];//stores the reversed form of the user input
char list_reversed_sum[1][1000000000];//stores the reversed form sum of products
//Methods
void reverse_number(char num_to_reverse[], char reverse_store[]); // Reverses numbers
void equalize_num(char lar_number[],char small_number[]);// Equalizes digits
void calculate_sum(char rev_num1[],char rev_num2[],char temporary_result[]);//Calculates the sum of two numbers
void digitWithNumber_multiplier(char num1, char reversed2[]);//Multiplies a single digit with the entire number
void Multiply(char num1[],char num2[]);//Multiplies the two numbers and prints out the result


//Calculates the result
void calculate_sum(char rev_num1[],char rev_num2[],char temporary_result[]){
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

//Multiplies a single digit of the first number with the second number
void digitWithNumber_multiplier(char num1, char reversed2[])
{
     
    int single_product;
    reversed_product= malloc(sizeof(char*)*1000000);// dynamically allocating memory for storing the product of the single digit of the first number and the second number
    temp_holder = malloc(sizeof(char*)*1000000);

	char temp_store[100];//saves the string form of each single product
	int hold = 0; // saves the hold after each multiplication
  

    int dig1;
    int dig2;
    
    
	for (int i = 0; i < strlen(reversed2); i++)
	{
        
        dig1 =  num1-'0';
        dig2 = reversed2[i]-'0';
		single_product = dig1 * dig2 + hold;
        
        
       
        

		if (single_product >= 10)
		{
            if (reversed2[i+1] == '\0')
            {
                sprintf(temp_store,"%d",single_product);
           
			    reversed_product[i] = temp_store[1];
                reversed_product[i+1] = temp_store[0]; 
            }else{
            
			sprintf(temp_store,"%d",single_product);
			hold = temp_store[0] - '0'; // storing the hold
           
			reversed_product[i] = temp_store[1];
            
            }   
		}
		else
		{
            
			reversed_product[i] = single_product + '0';
            hold = 0;
		}
        
    }

    if (indentation_counter == 0)
    {
           
        for (int i = 0; i < strlen(reversed_product); i++)
        {
            list_reversed_sum[0][i] = reversed_product[i];
        }
        
        
    }else{
    
     
    
    //Reversing the numbers so they could be indented correctly
    reverse_number(reversed_product,temp_holder);
    
    //Indenting the products after the first product
    for (int i = 0; i < indentation_counter; i++)
    {
        temp_holder[strlen(temp_holder)] = '0';
    }
    
   
      
  
    //getting the previous existing product
    for (int i = 0; i < strlen(list_reversed_sum[0]); i++)
    {
        existing_product[i] = list_reversed_sum[0][i];
    }
    

    reverse_number(temp_holder,reversed_product);
   

   if (strlen(reversed_product) >strlen(existing_product))
    {
        //Equalize the digits along with the indentation
         equalize_num(reversed_product,existing_product);
         
         
          
    }
    
    
    //Add them
    calculate_sum(reversed_product,existing_product,sum);
    

    //Store the sum
     for (int i = 0; i < strlen(sum); i++)
        {
            list_reversed_sum[0][i] = sum[i];
        }

    
   
    }
    

    

    


  indentation_counter++;
    
   
    
	
}

//Multiplies two numbers
void Multiply(char num1[],char num2[]){
    reverse_number(num1,reversed_num1);
    reverse_number(num2,reversed_num2);
    for (int i = 0; i < strlen(reversed_num1); i++)
    {
        
        digitWithNumber_multiplier(reversed_num1[i],reversed_num2);
    }

    //Fetching the final product and reverting back to its correct form
    reverse_number( list_reversed_sum[0],temp_holder);
    printf("Product :%s \n",temp_holder);
   
    indentation_counter = 0;
    
     
	
}
int main(){
    Multiply("18020","18020");
    
}