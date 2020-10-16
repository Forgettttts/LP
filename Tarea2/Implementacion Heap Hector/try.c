
#ifndef __HEAP_H__
#define __HEAP_H__

#include <stdio.h>
#include <stdlib.h>

typedef void *tipoElem;

typedef struct
{
    tipoElem *heap;
    int capacidad;
    int nElems;
    int error; //! Se usa error para ver si es que es un buen heap
}tHeap;

int comparador(void *primera, void *segunda) {
    printf("A ver si con esto funciona");
    return 1;
}

void printElem(void *elemento)
{
    printf("A ver si con esto funciona");
}

tHeap *newHeap(int(*comparador)(void*, void*), int (*printElem)(void*))
{
}

#endif