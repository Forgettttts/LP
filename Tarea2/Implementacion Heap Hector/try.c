
#ifndef __HEAP_H__
#define __HEAP_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void printFlotante(void *flotante)
{
    printf("%f", (*(float *)flotante));
}

int main(){
    void* puntero;
    float numero=123.456;
    puntero=&numero;
    printFlotante(puntero);
    return 0;
}

#endif