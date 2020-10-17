
#ifndef __HEAP_H__
#define __HEAP_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int cmpEntero(void *primera, void *segunda)
{
    if ((*(int*)primera)<(*(int*)segunda))
    {
        return 1;
    }
    else
    {
        return 0;
    }
    
    
}

int main(){
    int uno, dos;
    uno=3;
    dos=4;
    void* puntero1;
    void* puntero2;
    puntero1=&uno;
    puntero2=&dos;
    printf("Resultado=%d\n", cmpEntero(puntero1, puntero2));
    return 0;
}

#endif