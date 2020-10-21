#include "heap.h"

tHeap *newHeap(int (*comparador)(void *, void *), void (*printElem)(void *))
{
    tHeap* h = (tHeap*)malloc(sizeof(tHeap));
    if(h == NULL){
        return NULL;
    }
    h->error = 0;
    h->capacidad = 1;
    h->nElems = 0;
    h->heap = (tipoElem*)malloc(sizeof(tHeap)*(h->capacidad+1));
    if(h->heap == NULL) h->error = 1;
    h->cmp=comparador;
    h->print=printElem;
    return h;
}

void deleteHeap(tHeap* h){
    free(h->heap);
    free(h);
    return;
}

void growHeap(tHeap* h){
    h->capacidad *= 2;
    tipoElem* temp = (tipoElem*)realloc(h->heap, sizeof(tipoElem)*(h->capacidad+1));
    if(temp == NULL){
        h->error = 1;
        return;
    }
    h->heap = temp;
    return;
}

void clearHeap(tHeap* h){
    h->nElems = 0;
    return;
}

tipoElem topHeap(tHeap* h){
    return h->heap[1];
}

int sizeHeap(tHeap* h){
    return h->nElems;
}

int emptyHeap(tHeap* h){
    return !(h->nElems > 0);
}

int is_goodHeap(tHeap* h){
    return !h->error;
}

void swapElemsHeap(tHeap* h, int i, int j){
    tipoElem tmp = h->heap[i];
    h->heap[i] = h->heap[j];
    h->heap[j] = tmp;
    return;
}

void pushHeap(tHeap* h, tipoElem elem){ //! Quiero agregar un elemento nuevo
    int i = h->nElems+1; //? Se le asigna como posicion al nuevo elemento, la posicion sigueinte a el tamaño actual (se agrandara el heap si es necesario)
    if(i > h->capacidad){ //? En caso de que al agregar el elemento nuevo, sobrepasemos la capacidad actual
        growHeap(h); //? Agrandamos la capacidad
        if(!is_goodHeap(h)){ //? Si es que al agrandar la capacidad huibo algun error, se muestra mensaje de error y se retorna
            printf("Error al expandir la memoria del heap\n");
            return;
        }
    }
    h->heap[i] = elem; //? Se coloca el elemento en la posicion asignada
    while (i > 1) {
        int j = i/2; //? j es el padre de el elemeento en la posicion i
        if (h->cmp(h->heap[i], h->heap[j])){  //? Va el i antes que el j?
            swapElemsHeap(h, i, j); //? Si es que el i va antes que el j, se camian de lugar
        }
        i = j;
    }
    h->nElems++;
}

void popHeap(tHeap *h){ //! Queremos eliminar el elemento de la cabeza
    int i = 1; //! Estamos en la cabeza del heap (NODO RAIZ)
    h->heap[i] = h->heap[h->nElems]; 
    h->nElems--;
    //? Colocamos en la cabbeza, el ultimo elemento y disminuimos el tamaño del arreglo
    while (2 * i <= h->nElems){//? Mientras que el nodo, tenga al menos hijo izquierdo
        int izq = 2 * i;
        int der = 2 * i + 1;

        if (der > h->nElems || (h->cmp(h->heap[izq], h->heap[der]))){ //? Si es que no tiene hijo derecho || Si el izq esta correcto respecto al der
            if (h->cmp(h->heap[i], h->heap[izq])) //? Si es que el hijo izquierdo esta correctamente puesto respecto al padre, significa que estamos listos
                break;
            swapElemsHeap(h, i, izq); //? Si es que el izquierdo no esta bien colocado, haremos swap con el padre
            i = izq;
        }
        else{ //? Si es que tiene hijo derecho o el izq no esta correcto respecto al der
            if (h->cmp(h->heap[i], h->heap[der]))
                break;
            swapElemsHeap(h, i, der);
            i = der;
        }
    }
}

void printHeap(tHeap* h){
    printf("Heap:\n");
    printf("\tCapacidad: %d\n\tnElems: %d\n", h->capacidad, h->nElems);
    printf("\telems: [");
    for(int i = 1; i < h->nElems; i++){
        h->print(h->heap[i]);
        printf(" , ");
        }
    if (h->nElems > 0){
        h->print(h->heap[h->nElems]); //! Para que es esta linea? <-----------------------------
        }
    printf("]\n");
    return;
}

int cmpString(void *primera, void *segunda) //* Si es que el caracter inicial del primer string va antes que el del segundo, retorna 1, en cualquier otro caso, retorna 0
{
    int comienzo_primera = ((char *)primera)[0];
    int comienzo_segunda = ((char *)segunda)[0];
    if (comienzo_primera >= 65 && comienzo_primera <= 90)
    {
        comienzo_primera += 32;
    }
    if (comienzo_segunda >= 65 && comienzo_segunda <= 90)
    {
        comienzo_segunda += 32;
    }
    if (comienzo_primera < comienzo_segunda)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int cmpEntero(void *primera, void *segunda)
{
    if ((*(int *)primera) < (*(int *)segunda))
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int cmpFloat(void *primera, void *segunda)
{
    if ((*(float *)primera) > (*(float *)segunda))
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int cmpArreglo(void *primera, void *segunda)
{
    int cantidad1, suma1, cantidad2, suma2;
    suma1 = 0;
    suma2 = 0;
    cantidad1 = ((int *)primera)[0];
    cantidad2 = ((int *)segunda)[0];

    for (int i = 1; i < (cantidad1 + 1); i++)
    {
        suma1 += ((int *)primera)[i];
    }

    for (int j = 1; j < (cantidad2 + 1); j++)
    {
        suma2 += ((int *)segunda)[j];
    }
    if (suma1 < suma2)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void printString(void *string)
{
    printf("%s", ((char *)string));
}

void printEntero(void *entero)
{
    printf("%d", (*(int *)entero));
}

void printFlotante(void *flotante)
{
    printf("%f", (*(float *)flotante));
}

void printArreglo(void *arreglo)
{
    int cantidad1 = ((int *)arreglo)[0];
    printf("{");
    for (int i = 0; i < (cantidad1 + 1); i++)
    {
        printf("%d", ((int *)arreglo)[i]);
        if (i != cantidad1)
        {
            printf(",");
        }
    }
    printf("}");
}

