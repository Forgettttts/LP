

#include <stdio.h>
#include <stdlib.h>
#include "heap.h"

typedef struct
{
    int base;
    char* numero;
}tBase;

int BaseADecimal(char *original, int base)
{
    int len = strlen(original);
    int potencia = 1;
    int output = 0;
    int i;
    for (i = len - 1; i >= 0; i--){
        int numero = ((int)original[i]) - '0';
        if (numero >= base){
            printf("Numero invalido");
            return -1;
        }
        output += numero * potencia;
        potencia = potencia * base;
    }
    return output;
}

int cmpStruct(void *primera, void *segunda) {
    int numero1, numero2;

    numero1 = BaseADecimal(((tBase *)primera)->numero, ((tBase *)primera)->base);
    numero2 = BaseADecimal(((tBase *)segunda)->numero, ((tBase *)segunda)->base);

    if (numero1>numero2){
        return 1;}
    else{
        return 0;}
}

void printStruct(void* estructura){
    printf("%s", ((tBase *)estructura)->numero);
}

void heapSort(void **arreglo, int tam_arr, int (*comparador)(void *, void *), void (*printElem)(void *)){
    tHeap *heap = newHeap(comparador, printElem); //? Creo heap a retornar
    for (int i = 0; i < tam_arr; i++)
    {
        pushHeap(heap, arreglo[i]); //? Añade los elementos al heap
    }

    tipoElem retorno[tam_arr]; //? Creamos un heap para printear
    for (int j = 0; j < tam_arr; j++)
    {
        retorno[j] = topHeap(heap); //? Copiamos la raiz del heap, al arreglo
        popHeap(heap);              //? Eliminamos la raiz del heap
    }
    //* A este punto, el arreglo tiene todos los elementos del heap, en el mismo orden que estaba en él.
    for (int k = 0; k < tam_arr; k++)
    {
        heap->print(retorno[k]); //? Aqui ira printeando elemento por elemento, segun el tipo de dato del heap
    }

    deleteHeap(heap); //? Eliminamos el heap, para liberar la memoria
}

void maxBases(tBase* arreglo, int largo, int CantidadDeMaximos){
    tHeap* rankingBases= newHeap(cmpStruct, printStruct);
    for (int i = 0; i < largo; i++)
    {
        tipoElem actual= &((tipoElem)arreglo)[i];
        pushHeap(rankingBases, actual);
    }
    for (int j = 0; j < CantidadDeMaximos; j++)
    {
        tipoElem actual = &((tipoElem)arreglo)[j];
        printStruct(actual);
    }
}

    int main()
{
    /*
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
    */
   

    return 0;
}
