//! Funciones comparacion:
//? String:

void sort(void *string, char *destino){ //* Recibe el puntero al string original y un puntero a el string donde se copiara ordenado alfabeticamente
    for (int i = 0; i < strlen(string); i++)
    {
        strcpy(destino, (char *)string);
    }
    char temp;
    int i, j;
    int n = strlen(destino);
    for (i = 0; i < n - 1; i++)
    {
        for (j = i + 1; j < n; j++)
        {
            if (destino[i] > destino[j])
            {
                temp = destino[i];
                destino[i] = destino[j];
                destino[j] = temp;
            }
        }
    }
}

int cmpString(void *primera, void *segunda){ //* Recibe 2 strings, los ordena (con sort() ) y retorna 1 si es que el 1ero va antes que el 2d0, retorna 0 en CUALQUIER otro caso
    char *str1 = (char *)malloc(sizeof(strlen(primera)));
    char *str2 = (char *)malloc(sizeof(strlen(segunda)));

    printf("Palabra 1: %s, palabra 2: %s\n", primera, segunda);
    sort(primera, str1);
    sort(segunda, str2);
    printf("Palabra 1: %s, palabra 2: %s\n", str1, str2);
    int orden;
    if ((int)str1[0] < (int)str2[0])
    {
        orden = 1;
    }
    else
    {
        orden = 0;
    }
    free(str1);
    free(str2);
    return orden;
}

//! Funciones printeadoras
//? String:
