

#include <stdio.h>
#include <stdlib.h>
#include "heap.h"

//! La funcion comp retorna 1 si es que el primer elemento va antes del segundo, retornara 0 en el caso contrario
int cmpString(void *primera, void *segunda) {}
int cmpEntero(void *primera, void *segunda) {}
int cmpFlotante(void *primera, void *segunda) {}
int cmpArreglo(void *primera, void *segunda) {}

//! La funcion print, printeara el elemento entregado, sin caracteres en blan co (espacios, tabulaciones, saltos de linea, etc.)
void printString(void *elemento) {}
void printEntero(void *elemento) {}
void printFlotante(void *elemento) {}
void printArreglo(void *elemento) {}

int main(){
    int numeros[] = {4,3,2,1,2,4,6,7,8,9};

    tHeap* h = newHeap();
    for(int i = 0; i < 10; i++) pushHeap(h, numeros[i]);

    printHeap(h);

    while(!emptyHeap(h)){
        printf("%d ", topHeap(h));
        popHeap(h);
    }
    printf("\n");

    printHeap(h);

    deleteHeap(h);

    return 0;
}
