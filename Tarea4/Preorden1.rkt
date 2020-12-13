#lang scheme
(define preorden
  (lambda (lista function)
    (if (null? lista)
        '()
        (append (function(car lista)) (preorden (cadr lista) function) (preorden (caddr lista) function))
     )
   )
  )
