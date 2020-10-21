//! EN EL LINK HAY 3 ARCHIVOS (LOS QUE TENEMOS AQUI), PARA LA TAREA TENEMOS QUE SOBREESCRIBIR ESTOS?
#ifndef __HEAP_H__
#define __HEAP_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXSIZE 1000000

typedef void* tipoElem;

typedef struct{
    tipoElem* heap;
    int capacidad;
    int nElems;
    int error; //? Se usa error para ver si es que es un buen heap, 0 si es bueno, 1 si es malo
    int (*cmp)(void*, void*);
    void (*print)(void*);
}tHeap;

typedef struct 
{
    int base;
    char* numero;
}tBase;


int cmpString(void *primera, void *segunda);

int cmpEntero(void *primera, void *segunda);

int cmpFloat(void *primera, void *segunda);

int cmpArreglo(void *primera, void *segunda);

void printString(void *string);

void printEntero(void *entero);

void printFlotante(void *flotante);

void printArreglo(void *arreglo);

tHeap *newHeap(int (*comparador)(void *, void *), void (*printElem)(void *));

void deleteHeap(tHeap *h);

void clearHeap(tHeap *h);

tipoElem topHeap(tHeap *h);

int sizeHeap(tHeap* h)
{
    return h->nElems;
}

void popHeap(tHeap *h);

void pushHeap(tHeap *h, tipoElem elem);

int is_goodHeap(tHeap *h);

int emptyHeap(tHeap *h);

void printHeap(tHeap* h);

#endif
