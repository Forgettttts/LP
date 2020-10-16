#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char* perro="perro";
    char* gato="gato";
    char una_letra =perro[0];
    char otra_letra =gato[0];
    printf("como numeros: 1:%d, 2:%d \n", una_letra, otra_letra);
    if ((int)una_letra < (int)otra_letra){
        printf("una letra es menor que otra letra");}
    else{
        printf("Otra letra es menor que una letra");}
    
}