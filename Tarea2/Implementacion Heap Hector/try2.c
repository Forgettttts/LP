
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char string[] = "otrapruebasinmayusculas";
    char temp;

    int i, j;
    int n = strlen(string);

    printf("String before sorting - %s \n", string);

    for (i = 0; i < n - 1; i++)
    {
        for (j = i + 1; j < n; j++)
        {
            if (string[i] > string[j])
            {
                temp = string[i];
                string[i] = string[j];
                string[j] = temp;
            }
        }
    }
    printf("String after sorting - %s \n", string);
    return 0;
}