; matrix multiplication program for grad-pl
; concurrent programming languages group
; program written by: Derek Gaffney
; last update: April 21, 2017
(ns matrix-multiplication.core
  (:gen-class))

;m is number of rows for matrix a
;r is number of columns for matrix a
;r is number of rows for matrix b
;n is number of columns for matrix b
(defn define-constants
  []
  ; for square matrices m == r == n
  (def ^:const m 1500)
  (def ^:const r 1500)
  (def ^:const n 1500)
  (def ^:const max-num-size 10)) ;max size of a number in a matrix

; define how many cores the computer has
; work load among cores will be optimized based on this number
(def ^:const num-of-cores 8)

;given a size of how many numbers should be in the vector,
; returns a vector of that size filled with random numbers
(defn rand-num-vector-of-size
  [size]
  (into [] (take size (repeatedly #(rand-int max-num-size)))))

;given number of vectors v and size of those vectors s
; create a vector of vectors to simulate a matrix
(defn gen-v-vectors-size-s
  [v s]
  (into [] (take v (repeatedly #(rand-num-vector-of-size s)))))

;define matricies a and b with sizes defined by
; constants m r and n
;a is defined as row vector
;b is defined as column vector
(defn define-matrices
  []
  (def a (gen-v-vectors-size-s m r))
  (def b (gen-v-vectors-size-s n r)))

;make pair-vectors that pair each vector from a
; with its respective vector in b which will need
; to have the dot product taken of
(defn make-multiple-pair-vectors
  []
  (def ab-pair-vectors (map #(vector %1 %2) a b))
  )

;returns the dot product of two n sized vectors
(defn dot-product
  [v1 v2]
  (if (nil? v1)
    0
    (+ (* (first v1) (first v2)) (dot-product (next v1) (next v2)))))
