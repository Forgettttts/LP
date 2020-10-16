//! EN EL LINK HAY 3 ARCHIVOS (LOS QUE TENEMOS AQUI), PARA LA TAREA TENEMOS QUE SOBREESCRIBIR ESTOS?

#ifndef __HEAP_H__
#define __HEAP_H__

#include <stdio.h>
#include <stdlib.h>

#define MAXSIZE 1000000

typedef void* tipoElem;

typedef struct{
    tipoElem* heap;
    int capacidad;
    int nElems;
    int error; //! Se usa error para ver si es que es un buen heap, 0 si es bueno, 1 si es malo
}tHeap;

int comparador(void* primera, void* segunda){}

void printElem(void* elemento){}

tHeap *newHeap(int (*comparador)(void *, void *), int (*printElem)(void *)){
    tHeap *h = (tHeap *)malloc(sizeof(tHeap));
    if (h == NULL)
    {
        return NULL;
    }
    h->error = 0;
    h->capacidad = MAXSIZE;
    h->nElems = 0;
    h->heap = (tipoElem *)malloc(sizeof(tHeap) * (h->capacidad + 1));
    if (h->heap == NULL)
        h->error = 1;
    return h;
}

void deleteHeap(tHeap* h)
{
    free(h->heap);
    free(h);
    return;
}

void clearHeap(tHeap* h)
{
    h->nElems = 0;
    return;
}

tipoElem topHeap(tHeap* h)
{
    return h->heap[1];
}

int sizeHeap(tHeap* h)
{
    return h->nElems;
}

void popHeap(tHeap* h)
{
    int i = 1;
    h->heap[i] = h->heap[h->nElems]; //Se deja en la raiz, al ultimo elemento, y en la ultima hoja al primer elemento
    h->nElems--;
    while (2 * i <= h->nElems)
    {
        int izq = 2 * i;
        int der = 2 * i + 1;

        if (der > h->nElems || h->heap[izq] > h->heap[der])
        {
            if (h->heap[izq] < h->heap[i])
                break;

            swapElemsHeap(h, i, izq);
            i = izq;
        }
        else
        {
            if (h->heap[der] < h->heap[i])
                break;

            swapElemsHeap(h, i, der);
            i = der;
        }
    }
}

void pushHeap(tHeap* h, tipoElem elem){
    int i = h->nElems + 1;
    if (i > h->capacidad)
    {
        growHeap(h);
        if (!is_goodHeap(h))
        {
            printf("Error al expandir la memoria del heap\n");
            return;
        }
    }
    h->heap[i] = elem;
    while (i > 1)
    {
        int j = i / 2;
        if (h->heap[i] > h->heap[j])
        {
            swapElemsHeap(h, i, j);
        }
        i = j;
    }
    h->nElems++;
}

int is_goodHeap(tHeap* h)
{
    return !h->error;
}

int emptyHeap(tHeap* h)
{
    return !(h->nElems > 0); //! Revisar el funcionamiento de esto
}

void printHeap(tHeap* h)
{   //! Revisar esto, esta preparado solo para printear enteros, revisar si es que
    //!  debe ir igual, a pesar de que habra funcion printeadora para cada tipo de dato entregado
    printf("Heap:\n");
    printf("\tCapacidad: %d\n\tnElems: %d\n", h->capacidad, h->nElems);
    printf("\telems: [");
    for (int i = 1; i < h->nElems; i++)
        printf("%d, ", h->heap[i]);
    if (h->nElems > 0)
        printf("%d", h->heap[h->nElems]);
    printf("]\n");
    return;
}

#endif
