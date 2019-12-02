//Not finished.. only left with Division
//Author : Abel Tsegaye
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "../Day 1/LargeNumberAdder.c"
#include "../Day 2/LargeNumberMultiplier.c"

char num1[1000000];
char num2[1000000];
char signed1[1000000];
char signed2[1000000];
char operator[1];
void calculate(char num1[],char operator[],char num2[]){
    if (operator[0] == '+')
    {
       addition_calculator(num1,num2);
    }else if(operator[0] == '*'){
        Multiply(num1,num2);
    }else if(operator[0] == '-'){
       
        addSign(num2,signed2);
        addition_calculator(num1,signed2);
        
    }
    
}
int main(){
    printf("Hello. Please enter your first number?\n");
    scanf("%s", &num1);
    printf("Hello. Please enter your operator as +,-,*,/ ?\n");
    scanf("%s", &operator);;
    printf("Please enter your second number?\n");
    scanf("%s", &num2);
    calculate(num1,operator,num2);
    
    

}