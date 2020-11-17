import re

def Pascal(niveles):
    row = [1]
    zero = [0]
    for i in range(niveles):
        row = [i+d for i, d in zip(row + zero, zero + row)]
    return(row)

def bisiesto(ano):
    anito=int(ano)
    if (anito%4==0):
        if (anito%100==0):
            if(anito%400==0):
                return True
        else:
            return True
    else:
        return False

m30=['04','06','09','11']# Lista de los numero de los meses que tienen 30 días
m31=['01','03','05','07','08','10','12']# Lista de los numero de los meses que tienen 31 días

archivo = open('palabras.txt', 'r', encoding='utf-8')

rgb= re.compile('[#]{1}([0-9A-F]){6}')
hsl = re.compile('(?P<prefijo>[h-s]{3})[(]{1}[ ]*(?P<angulo>[\d]{1,3})[ ]*[,]{1}[ ]*(?P<saturacion>[\d]{1,3})[%]{1}[ ]*[,]{1}[ ]*(?P<brillo>[\d]{1,3})[%]{1}[ ]*[)]{1}')
directorio = re.compile(r'([A-ZÑñ]:|[\.]{1,2}|[\~])[\\]((\w[^\\\/\:\*\?\"\>\<\|]*|[\.]{1,2})[\\])*([a-zA-Z0-9Ññ][\.a-zA-Z0-9Ññ]*)+')
correo = re.compile(r'([\w!#$%&‘’*+\-\/=?^{|}~]+([\.]?[\w!#$%&‘’*+\-\/=?^{|}~])+)+@{1}(([A-Za-z0-9\-]+\.)+([A-Za-z])+)')
fecha = re.compile('(?P<ano>[0-9]{4})[-](?P<mes>([0-1][0-9]|[0-9]))[-](?P<dia>(([0-3][0-9])|[0-9]))')
pascal = re.compile(r'([\{]{1}((1)|(1 1)|(1([ ][0-9]+)* 1))[\}]{1})')
XDSON = re.compile(r'[\<][ ]*([\w]+[ ]*\=[ ]*(([1-9][0-9]*)|((\'[A-Za-z0-9]*\')|(\"[A-Za-z0-9]*\"))*|(\[(((\'[A-Za-z0-9]*\'|\"[A-Za-z0-9]*\")*|([1-9][0-9]*)*)[ ]*[\,]?[ ]*)*\]))*[ ]*[\,]?[ ]*)*[\>]')

for Linea in archivo:
    linea=Linea.strip('\n')
    if (rgb.match(linea)): #? --------------Caso RGB --------------
        print('RGB')
        
    elif (hsl.match(linea)): #?-------------- Caso HSL--------------
        match = hsl.match(linea)
        if (match.group('prefijo') == 'hsl' and int(match.group('angulo')) <= 360 and int(match.group('angulo')) >= 0 and int(match.group('saturacion')) <= 100 and int(match.group('saturacion')) >= 0 and int(match.group('brillo')) <= 100 and int(match.group('brillo')) >= 0):
            print('HSL')
            
    elif (fecha.match(linea)): #?-------------- Caso Fecha--------------
        match= fecha.match(linea)
        if (match.group('mes') == '02' or match.group('mes') == '2'):
            if( bisiesto(match.group('ano'))):
                if (int(match.group('dia'))<=29):
                    print('Fecha')
            else:
                if (int(match.group('dia')) <= 28):
                    print('Fecha')
        elif (int(match.group('mes')) <= 12 and int(match.group('mes')!=00)):
            if ((match.group('mes')) in m30 and int(match.group('dia')) <= 30 and int(match.group('dia')) != 00):
                print('Fecha')
            elif (match.group('mes') in m31 and int(match.group('dia')) <= 31 and int(match.group('dia')) != 00):
                print('Fecha')
                
    elif (pascal.match(linea)):  #?-------------- Caso Pascal--------------
        lineaza = linea.strip('\n')
        linea_nueva = lineaza.split()
        linea_nueva[0] = '1'
        linea_nueva[-1] = '1'
        for posicion in range(len(linea_nueva)):
            linea_nueva[posicion] = int(linea_nueva[posicion])
        if (linea_nueva == Pascal(len(linea_nueva)-1)):
            print('Pascal')
            
    elif (correo.match(linea)):    #?-------------- Caso Correo--------------
        print('Correo')
        
    elif (directorio.match(linea)):  #?-------------- Caso Directorio--------------
        print('Directorio')
        
    elif(XDSON.match(linea)):
        print('XDSON')
        
    else:
        print('No pertenece al lenguaje')
        
archivo.close()
