//! Funciones comparacion:
//? String:
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

//? Entero
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

//? Flotante
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

//? Arreglo
int cmpArreglo(void *primera, void *segunda)
{
    int cantidad1, suma1, cantidad2, suma2;
    suma1 = 0;
    suma2 = 0;
    cantidad1 = ((int *)primera)[0];
    cantidad2 = ((int *)segunda)[0];

    for (int i = 1; i < (cantidad1 + 1); i++){
        suma1 += ((int *)primera)[i];
    }

    for (int j = 1; j < (cantidad2 + 1); j++){
        suma2 += ((int *)segunda)[j];
    }
    if (suma1 < suma2){
        return 1;
    }
    else{
        return 0;
    }
}

//! Funciones printeadoras
//? String:
void printString(void* string){
    printf("%s", ((char*)string));
}

//? Entero
void printEntero(void *entero)
{
    printf("%d", (*(int *)entero));
}

//? Flotante
void printFlotante(void *flotante)
{
    printf("%f", (*(float *)flotante));
}

//? Arreglo
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

