#lang scheme

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

(define (calculoInterno n x)
  (/(* (expt -1 n) (expt x (+ (* 2 n) 1)))(calculoFactorial (+(* 2 n)1))))

(define seno
  (lambda (n)
    (let senito((p n)(a 0)(s 0))
      (if (= a 500)
          (exact->inexact s)
          (senito p(+ a 1)(+ s (calculoInterno a p)))
          )
      )
    )
  )