
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*
int CharAInt(char numero)
{
    numero >= '0' && numero <= '9'
        return (int)numero - '0';
    else
        return (int)numero - 'A' + 10;
}

int BaseADecimal(char *original, int base)
{
    int len = strlen(original);
    int potencia = 1; 
    int output = 0;   
    int i;
    for (i = len - 1; i >= 0; i--){
        int numero = ((int)original[i]) - '0';
        if (numero >= base)
        {
            printf("Invalid Number");
            return -1;
        }
        output += numero * potencia;
        potencia = potencia * base;
    }
    return output;
}*/

char* strev(char *str)
{
    printf("entra\n");
    int len = strlen(str);
    int i;
    printf("Antes del for, largo=%d\n", len);
    for (i = 0; i < len / 2; i++)
    {
        char temp = str[i];
        printf("letra que sale: %c", temp);
        str[i] = str[len-1-i];
        printf(" - letra que entra:%c\n", str[i]);
        str[len - 1 - i] = temp;
    }
    printf("Termina con str=%s\n", str);
    return str;
}

int main()
{
    char *str = "abcdefghijk";
    printf("%s\n", str);
    printf("aki ta la salida: %s\n", strev(str));
    return 0;
}
