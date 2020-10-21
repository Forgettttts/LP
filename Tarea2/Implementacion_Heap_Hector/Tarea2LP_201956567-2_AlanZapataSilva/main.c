#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "heap.h"

typedef struct
{
    int base;
    char* numero;
}tBase;

/*****
* int BaseADecimal
******
* Recibe un string que describe un numero en la base indicada en el otro parametro, que es la base en la que esta el otro numero. Lo transforma
* a un numero decimal, el cual es retornado.
******
* Input:
* char* original : String que describe un numero (el cual esta escrito en alguna base, la cual esta especificada en el prox. parametro)
* int base : Base en la cual esta escrito el numero descrito por el string contenido en el parametro anterior.
******
* Returns:
* int, Numero ya transformado a un numero decimal.
*****/
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

/*****
* int cmpStruct
******
* Recibe dos punteros tipo void que apuntaran a structs tipo tBase, si es que el struct representado por el primer parametro, va primero (segun
* los criterios de la tarea), se retornara un entero 1, en cualquier otro caso, retornara un entero 0.
******
* Input:
* void* primera : Puntero a void que apuntara, al usarse, a un struct tipo tBase.
* void* segunda : Puntero a void que apuntara, al usarse, a un struct tipo tBase.
******
* Returns:
* int, se retornara un entero 1 en caso de que el struct tipo tBase apuntado por el primer parametro vaya antes que el struct apuntado en el 
* segundo parametro segun los criterios de la tarea, en cualquier otro caso, retornara un entero 0.
*****/
int cmpStruct(void *primera, void *segunda) {
    int numero1, numero2;

    numero1 = BaseADecimal(((tBase *)primera)->numero, ((tBase *)primera)->base);
    numero2 = BaseADecimal(((tBase *)segunda)->numero, ((tBase *)segunda)->base);

    if (numero1>numero2){
        return 1;}
    else{
        return 0;}
}

/*****
* void printStruct
******
* Recibe un puntero tipo void, el cual apunta a un struct tipo tBase. La funcion printeará el string que representa a un numero almacenado en el campo 
* numero' del struct.
******
* Input:
* void* estructura: Puntero a void el cual apunta a un struct tipo tBase.
******
* Returns:
* No tiene retorno, es de tipo void.
*****/
void printStruct(void* estructura){
    printf("%s", ((tBase *)estructura)->numero);
}

void heapSort(void **arreglo, int tam_arr, int (*comparador)(void *, void *), void (*printElem)(void *)){
    tHeap *heap = newHeap(comparador, printElem);
    for (int i = 0; i < tam_arr; i++)
    {
        pushHeap(heap, arreglo[i]); 
    }

    tipoElem retorno[tam_arr]; 
    for (int j = 0; j < tam_arr; j++)
    {
        retorno[j] = topHeap(heap); 
        popHeap(heap);              
    }
    for (int k = 0; k < tam_arr; k++)
    {
        heap->print(retorno[k]); 
    }

    deleteHeap(heap);
}

void maxBases(tBase* arreglo, int largo, int CantidadDeMaximos){
    tHeap* rankingBases= newHeap(cmpStruct, printStruct);
    for (int i = 0; i < largo; i++)
    {
        tipoElem actual = (tipoElem)&(arreglo[i]);
        pushHeap(rankingBases, actual);
    }
    printf("Los %d maximos, son:\n", CantidadDeMaximos);
    for (int j = 0; j < CantidadDeMaximos; j++)
    {
        tipoElem actual = (tipoElem)&(arreglo[j]);
        printf("\t%d) ", (j+1));
        printStruct(actual);
        printf("\n");
    }
    deleteHeap(rankingBases);
}

    int main(){
}