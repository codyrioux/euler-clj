(ns euler-clj.euler3-test
  (:use clojure.test
        euler-clj.euler3)
  (:require [simple-check.core :as sc]
            [simple-check.generators :as gen]
            [simple-check.properties :as prop]))

(deftest factors-test
  (testing "Factors function"
    (is (= [1] (factors 7)))
    (is (= [1 2 3] (factors 6)))
    (is (= [] (factors 0)))))

(deftest prime-test
  (testing "Prime function"
    (is (= true (prime? 5)))
    (is (= true (prime? 11)))
    (is (= true (prime? 3)))
    (is (= false (prime? 6)))))

(def prop-prime-one-factor 
  (prop/for-all [i gen/int]
                (if (prime? i)
                  (is (= [1] (factors i)))
                  (is (not= [1] (factors i))))))

(deftest prime-factors
  (sc/quick-check 10 prop-prime-one-factor))
