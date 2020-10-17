#include <stdio.h>
#include <stdlib.h>

typedef void* perro;

int main(){
    int *arreglo1 = (int *)malloc(sizeof(int) * 4);
    int *arreglo2 = (int *)malloc(sizeof(int) * 5);
    arreglo1[0] = 3;
    arreglo1[1] = 234578;
    arreglo1[2] = 6;
    arreglo1[3] = 8;
    arreglo2[0] = 4;
    arreglo2[1] = 6;
    arreglo2[2] = 7;
    arreglo2[3] = 9;
    arreglo2[4] = 3;
    perro puntero1;
    perro puntero2;
    puntero1 = arreglo1;
    puntero2 = arreglo2;
    printf("contenido 1: %d, y del 2: %d\n", arreglo1[1], ((int*)puntero1)[1]);

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
