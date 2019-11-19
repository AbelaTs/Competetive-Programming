#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void isocelessMaker(int num_rows){
    int row_counter = 1;
    if (num_rows == 1)
    {
        printf("%s","*");
    }else{
    
    
    for (int count = num_rows; count > 0; count--)
    {
        
        spacePrinter(count);

        starPrinter(row_counter);

        printf("%s \n","");
        row_counter ++;
        
        
    }
    }
    
}
//Prints stars
void starPrinter(int row_count){
    for (int star_count = 0; star_count < row_count + row_count-1; star_count++)
        {
            printf("%s","*");
        }
}
//Prints space
void spacePrinter(int number_rows){
     for (int space_count = 0; space_count <= number_rows-1; space_count++)
        {
            printf("%s"," ");
        }

}
int main(){
    int number_of_rows;
    printf("Please enter the size of isosceles triangle you want me to make :");
    scanf("%d",&number_of_rows);
    isocelessMaker(number_of_rows);
}
