;destructures the vector of two vectors called pair-vectors
; allows the ability to send the individual vectors
; to the dot-product function
(defn pre-dot-product
  [pair-vectors]
  (let [[v1 v2] pair-vectors]
    (dot-product v1 v2)
    )
  )

;perform matrix multiplication without multi-core parallel optimization
(defn matrix-multiply
  []
  (dorun (map pre-dot-product ab-pair-vectors))
  )

;perform matrix multiplication using multi-core parallel optimization
; by using pmap with partitioned workload sets
(defn pmatrix-multiply
  []
  (dorun (pmap (fn [abpv] (doall (map pre-dot-product abpv)))
    (partition-all (/ m num-of-cores)  ab-pair-vectors)))
  )

;prints matrix a
(defn printa
  []
  (println "Matrix A:")
  (loop [moda a]
    (when-let [v1 (first moda)]
      (println v1)
      (recur (rest moda)))
    )
  )

;prints matrix b
(defn printb
  []
  (println "Matrix B (Transposed):")
  (loop [modb b]
    (when-let [v2 (first modb)]
      (println v2)
      (recur (rest modb))
      )
    )
  )

; main entry point of the program
(defn -main
  [& args]
  (define-constants)
  (define-matrices)
  ;(printa)
  ;(printb)
  ;(println)
  (make-multiple-pair-vectors)
  ;(print ab-pair-vectors)
  ;(println (time (matrix-multiply))) ;slower version of matrix multiplication
  (println (time (pmatrix-multiply))) ;faster, parallel matrix multiplication
  )
