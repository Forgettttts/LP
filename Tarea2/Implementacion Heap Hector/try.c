
#ifndef __HEAP_H__
#define __HEAP_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void sort(void* string, char* destino){
    for (int i = 0; i < strlen(string); i++)
    {
        strcpy(destino, (char*)string);
    }
    char temp;
    int i, j;
    int n = strlen(destino);
    for (i = 0; i < n - 1; i++)
    {
        for (j = i + 1; j < n; j++)
        {
            if (destino[i] > destino[j])
            {
                temp = destino[i];
                destino[i] = destino[j];
                destino[j] = temp;
            }
        }
    }
}

int cmpString(void *primera, void *segunda){ //! Retorna 1 si es que el 1ero va antes que el 2d0, retorna 0 en CUALQUIER otro caso
    char * str1= (char *)malloc(sizeof(strlen(primera)));
    char * str2= (char *)malloc(sizeof(strlen(segunda)));

    printf("Palabra 1: %s, palabra 2: %s\n", primera, segunda);
    sort(primera, str1);
    sort(segunda, str2);
    printf("Palabra 1: %s, palabra 2: %s\n", str1, str2);
    int orden;
    if ((int)str1[0]<(int)str2[0]){
        orden=1;
    }
    else{
        orden=0;
    }
    free(str1);
    free(str2);
    return orden;
}

int main(){
    char *otra_palabra = "pruebasinmayusculas";
    char *palabra = "otrepruebesinmeyuscules";
    printf("El resultado es: %d\n", cmpString(palabra, otra_palabra));
    return 0;
}

#endif