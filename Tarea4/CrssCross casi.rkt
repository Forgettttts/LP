#lang scheme

;;(numeroAzar lista)
;;Funcionamiento: Recibe una lista, retorna un numero al azar entre 0 y un numero menos que el largo de la lista
;;Retorno de la función: Un numero al azar entre 0 y un numero menos que el largo de la lista
(define numeroAzar
  (lambda (lista)
    (random (length lista)) 
    )
  )

;;(armarListasNuevas largoLista lista1 lista2 limiteInferior limiteSuperior PonerUnCero newList)
;;Funcionamiento: Recibe el largo de una de las dos listas, las dos listas, el corte inferior, el corte superior (aunque sean iguales), un 0 (por un error, lo deje asi, no es elegante,
;;                pero funciona) y una nueva lista, donde se guardara la lista nueva, que mezcla las dos listas segun el corte que se entregue, sirve para armar cada una de las 2 listas
;;                que se necesitan a la vez
;;Retorno de la función: No tiene retorno, simplemente muestra por pantalla la lista recien creada
(define armarListasNuevas
  (lambda (largoLista lista1 lista2 limiteInferior limiteSuperior PonerUnCero newList1)
    (let armar ((larguito largoLista)(listaOriginal lista1)(listaOriginal2 lista2)(limite1 limiteInferior)(limite2 limiteSuperior)(iteracion PonerUnCero)(nuevaLista newList1))
      (if (not(= iteracion larguito)) ;; Si es que no estamos en el final de las listas, hay que seguir trabajando
          (cond
            [(or (< iteracion limite1)(>= iteracion limite2))
             (armar larguito (cdr listaOriginal )(cdr listaOriginal2 )limite1 limite2 (+ iteracion 1)
                    (append nuevaLista (list(car listaOriginal ))))
             ]
            [(and(>= iteracion limite1)(< iteracion limite2));;Si es que estamis bsobre el limite inferior, y bajo el superior, hay que añadir desde la 2
             (armar larguito (cdr listaOriginal )(cdr listaOriginal2 )limite1 limite2 (+ iteracion 1) (append nuevaLista (list(car listaOriginal2 ))))
             ]
            )
          (display nuevaLista)
          )
      )
    )
  )

(define crossrd
  (lambda (l1 l2)
    (cond
      [(= (length l1) 0) "La primera lista esta vacia, ingrese dos listas del mismo tamaño."]
      [(= (length l2) 0) "La segunda lista esta vacia, ingrese dos listas del mismo tamaño."]
      [(> (length l1) (length l2)) "La primera lista es mas larga que la segunda, ingrese listas del mismo tamaño"]
      [(< (length l1) (length l2)) "La segunda lista es mas larga que la primera, ingrese listas del mismo tamaño"]
      [else
       (let ((corte1 (numeroAzar l1 )) (corte2 (+(numeroAzar l1 ) 1)) ( listaDeSalida (list)) )
         (cond
           [(= corte1 corte2)
            (armarListasNuevas (length l1) l1 l2 corte1 corte2 0 listaDeSalida )
            (armarListasNuevas (length l1) l2 l1 corte1 corte2 0 listaDeSalida )
            ]
           [(> corte1 corte2)
            (armarListasNuevas (length l1) l1 l2 corte2 corte1 0 listaDeSalida)
            (armarListasNuevas (length l1) l2 l1 corte2 corte1 0 listaDeSalida)
            ]
           [(< corte1 corte2)
            (armarListasNuevas (length l1) l1 l2 corte1 corte2 0 listaDeSalida)
            (armarListasNuevas (length l1) l2 l1 corte1 corte2 0 listaDeSalida)
            ]
           )
         )
       ]
      )
    )
  )
