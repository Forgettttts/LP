#lang scheme

;Funcion: factorial n
;Parametros: n
;Descripcion: calcula el factorial de un numero ingresado
;n es un numero entero
;Retorno: el factorial del elemento n.
(define (factorial n)
  (let fac ((val 1) (f n))
    (if (= f 0)
        val
        (fac (* val f) (- f 1))
        )
    ) 
  )

;x ES EL VALOR QUE PROVIENE DEL SENO!
;n ES EL ELEVADO (-1)^n

(define (formula n x)
  (/ (* (expt -1 n) (expt x (+ (* 2 n) 1)) (factorial (+(* 2.0 n)1))))
  )

(define (seno x)
  (let repetir ((valor 0)(value 50))  ;VER EL VALOR DE ITERACIONES
    (if (= value 0)  ;Si es igual a 0, se imprime directamente el 0
        valor
        (repetir (+ valor (formula value x))(- value 1))
        )
    )
  )

