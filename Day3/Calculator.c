//Author : Abel Tsegaye
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "../Day 1/LargeNumberAdder.c"
#include "../Day 2/LargeNumberMultiplier.c"

void calculate(char num1[],char operator[],char num2[]){
    if (operator[0] == '+')
    {
       addition_calculator(num1,num2);
    }else if(operator[0] == '*'){
        Multiply(num1,num2);
    }
    
}
int main(){
    char num1[1000000];
    printf("Hello. Please enter your first number?\n");
    scanf("%s", &num1);
    char operator[1];
    printf("Hello. Please enter your operator as +,-,*,/ ?\n");
    scanf("%s", &operator);
    char num2[1000000];
    printf("Please enter your second number?\n");
    scanf("%s", &num2);
    calculate(num1,operator,num2);
    
    

}