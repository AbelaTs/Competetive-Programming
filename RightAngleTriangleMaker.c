#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void hyphotenesMaker(int num_rows){
    for (int counter = 1; counter <= num_rows; counter++)
    {
        for (int num_stars = 0; num_stars < counter; num_stars++)
        {
            printf("%s","*");
        }
        printf("\n");
        
    }
    
    
}
int main(){
    int number_of_rows;
    printf("Please enter the size of right angle triangle you want me to make :");
    scanf("%d",&number_of_rows);
    hyphotenesMaker(number_of_rows);
}