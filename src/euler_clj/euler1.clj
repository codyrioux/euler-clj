(ns euler-clj.euler1
  "Project Euler problem 1 using core.typed
   Code borrowed from Adam Bard at 
   http://adambard.com/blog/core-typed-vs-haskell/ Thanks for getting
   me started Adam!"
  (:require [clojure.core.typed :refer [ann check-ns Int]])
  (:import [clojure.lang ISeq]))

(ann ^:no-check clojure.core/mod [Int Int -> Int])

(ann div-by [Int Int -> Boolean])
(defn div-by [x y]
  (== (mod y x) 0))

(ann div-by-3-or-5 [Int -> Boolean])
(defn div-by-3-or-5 [x]
  (or (div-by 3 x) (div-by 5 x)))

(ann euler1 [Int -> Int])
(defn euler1 [n]
  (reduce + (filter div-by-3-or-5 (range n))))

(ann -main [-> nil])
(defn -main []
  (prn (euler1 1000)))

(comment
  (check-ns)
  )
