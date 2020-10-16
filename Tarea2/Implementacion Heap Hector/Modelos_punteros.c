#include <stdio.h>
#include <stdlib.h>

typedef void* perro;

int main(){
    perro arreglo; //! Ejemplo arreglo enteros
    int *arreglote = (int *)malloc(sizeof(int) * 5);
    arreglote[1] = 5;
    arreglo = arreglote;
    printf("contenido 1: %d, y del 2: %d\n", arreglote[1], ((int*)arreglo)[1]);

    perro numero; //! Ejemplo INT
    int numerote=7;
    numero=&numerote;
    printf("nuemro= %d\n",*(int*)(numero));

    perro letra;  //! Ejemplo char
    char letrita = 'a';
    letra=&letrita;
    printf("caracter=%c\n", *(char*)letra);

    perro string;  //! Ejemplo string
    char* stringote="Fernando";
    string= stringote;
    printf("El string es: %s, y su primer caracter es: %c\n", ((char*)string), ((char*)string)[0]);

    return 0;
}
