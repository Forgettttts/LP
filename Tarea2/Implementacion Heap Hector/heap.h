//! EN EL LINK HAY 3 ARCHIVOS (LOS QUE TENEMOS AQUI), PARA LA TAREA TENEMOS QUE SOBREESCRIBIR ESTOS?

#ifndef __HEAP_H__
#define __HEAP_H__

#include <stdio.h>
#include <stdlib.h>

typedef int tipoElem; //! AQUI EL TIPO DE DATO NO DEBERIA SER VOID?

typedef struct{
    tipoElem* heap;

    int capacidad;
    int nElems;
    int error; //! A QUE SE REFIERE CON 'ERROR'?
}tHeap;

tHeap* newHeap();{
}

void deleteHeap(tHeap* h);{
}


void clearHeap(tHeap* h);{
}

tipoElem topHeap(tHeap* h);{
}

int sizeHeap(tHeap* h);{
}

void popHeap(tHeap* h);{
}

void pushHeap(tHeap* h, tipoElem elem);{
}

int is_goodHeap(tHeap* h);{
}

int emptyHeap(tHeap* h);{
}


void printHeap(tHeap* h);{
}



#endif
