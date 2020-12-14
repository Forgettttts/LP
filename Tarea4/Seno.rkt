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

;;(calculoInterno n x)
;;Funcionamiento: Funcion que encapsula la parte del calculoq que esta dentro de la sumatoria en la formula del teorema de Maclaurin, el parametro 'n' es la iteracion en la que va de la
;;                suma, y 'x' es el numero al cual se le esta calculando el seno
;;Retorno de la función: Calculo interno de la sumatoria en la formula del teorema de Maclaurin, en la iteracion actual, respecto a el numero 'x' entregado para calcular su seno
(define (calculoInterno n x)
  (/(* (expt -1 n) (expt x (+ (* 2 n) 1)))(calculoFactorial (+(* 2 n)1))))

(define seno
  (lambda (n)
    (let senito((p n)(a 0)(s 0))
      (if (= a 666)
          (exact->inexact s)
          (senito p(+ a 1)(+ s (calculoInterno a p)))
          )
      )
    )
  )