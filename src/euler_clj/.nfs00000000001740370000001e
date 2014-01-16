(ns euler-clj.euler2
  "Project Euler problem 2 using core.typed
   Code borrowed from Adam Bard at 
   http://adambard.com/blog/core-typed-vs-haskell/ Thanks for getting
   me started Adam!"
  (:require [clojure.core.typed :refer [ann check-ns Int fn>]])
  (:import [clojure.lang ISeq]))

(ann fibs (ISeq Int))
(def fibs
  (lazy-cat [0 1] (map + fibs (rest fibs))))

(ann euler2 [Int -> Int])
(defn euler2 [n]
  (let [lt-n (fn> [m :- Int] (> n m))]
    (reduce + (filter even? (take-while lt-n fibs)))))

(ann -main [-> nil])
(defn -main []
  (prn (euler2 4000000)))

(comment
  (check-ns)
  )
