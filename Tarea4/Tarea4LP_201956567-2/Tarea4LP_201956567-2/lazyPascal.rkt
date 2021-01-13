#lang scheme

;;(calculoFactorial n)
;;Funcionamiento: Calcula el factorial del numero 'n' ingresado como parametro, con recursividad de cola
;;Retorno de la función: Factorial del numero 'n' ingresado como parametro
(define calculoFactorial
  (lambda(n)
    (let fact ((i n) (a 1))
      (if (= i 0)
          a
          (fact (- i 1) (* a i))
          )
      )
    )
  )

;;(calculoCombinatoria numero iteracion)
;;Funcionamiento: Calcula la combinatoria de un numero en cierta iteracion, usado dentro del calculo de cada una de las lienas de pascal
;;Retorno de la función: Combinatoria del numero entregado como parametro en la iteracion entregada tambien en los parametros
(define (calculoCombinatoria numero iteracion)
    (/(calculoFactorial numero)(*(calculoFactorial iteracion)(calculoFactorial (- numero iteracion))))
  )

;;(generarPascal n iteracionInicial)
;;Funcionamiento: Calcula la linea de la piramide de pascal que se le entregue, iteracion inicial=0.
;;Retorno de la función: Linea de la piramide de pascal, solicitada en el parametro
(define generarPascal
  (lambda (n iteracionInicial)
    (let linea ((numero n)(iteracion iteracionInicial))
      (if (<= iteracion numero)
         (append (calculoCombinatoria numero iteracion) (linea numero (+ iteracion 1)))
         '()
          )
      )
    )
  )

(define lazypascal
  (lambda (n)
    (if(>= n 0)
       (generarPascal n 0)
       "El numero entregado debe ser mayor o igual que 0, intentelo nuevamente.")
    )
  )
(lazypascal 0)