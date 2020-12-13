#lang scheme
(define numeroAzar
  (lambda (lista)
    (random (length lista)) 
    )
  )

(define armarListas
  (let armar ((l11 lista1)(l22 lista2)(limite1 limiteInferior)(limite2 limiteSuperior)(iteracion 0))
    (if (= iteracion (length l11))
        ;; NO SE QUE HAY QUE HACER EN EL CASO BASE XD
        
        )
    )

(define crossrd
  (lambda (lista1 lista2)
    (cond
      [(= (length l1) 0) "La primera lista esta vacia, ingrese dos listas del mismo tamaño."]
      [(= (length l2) 0) "La segunda lista esta vacia, ingrese dos listas del mismo tamaño."]
      [(> (length l1) (length l2)) "La primera lista es mas larga que la segunda, ingrese listas del mismo tamaño"]
      [(< (length l1) (length l2)) "La segunda lista es mas larga que la primera, ingrese listas del mismo tamaño"]
      [else (let ((corte1 numeroAzar(l1))(corte2 numeroAzar(l1)))
              (cond
                [(= corte1 corte2)
                 ()
                 ]
                [(> corte1 corte2)]
                [(< corte1 corte2)]
                )
              )]
      )
   )
  )