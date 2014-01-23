(ns euler-clj.euler3
  "Project euler problem 3.
   Uses a very naive prime tester, would use a sieve or probabilistic
   prime algorithm for a larger problem set. Went naive because this is
   intended to be run once and only once.
   What is the largest prime factor of the number 600851475143?"
  (:require [clojure.core.typed :refer
             [ann check-ns Int fn> non-nil-return Seq cf NonEmptyVec]]
            [euler-clj.euler1 :as e1]
            [clojure.math.numeric-tower :refer [exact-integer-sqrt ceil]]))

(non-nil-return clojure.lang.Numbers/quotient :all)
(ann ^:no-check clojure.math.numeric-tower/exact-integer-sqrt [Int -> (NonEmptyVec Int)])
(ann ^:no-check clojure.math.numeric-tower/ceil [Number -> Int])

(ann factors [Int -> (Seq Int)])
(defn factors
  [n]
  (filter (fn> [m :- Int] (e1/div-by m n)) (range 2 (inc (ceil (/ n 2))))))

(ann prime? [Int -> Boolean])
(defn prime? [n] (empty? (factors n)))

(ann euler3 [Int -> Number])
(defn euler3
  [n]
  (let
    [[f & r] (filter prime? (factors n))]
    (if f (apply max f r) (throw (Exception. (str n " does not have any prime factors."))))))

(ann -main [-> nil])
(defn -main
  []
  (println (euler3 600851475143)))
