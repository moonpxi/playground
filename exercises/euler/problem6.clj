(ns eulerclj.problem6)

;The sum of the squares of the first ten natural numbers is,
;
;12 + 22 + ... + 102 = 385
;The square of the sum of the first ten natural numbers is,
;
;(1 + 2 + ... + 10)2 = 552 = 3025
;Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
;
;Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

; brute force
(defn square [num]
  (* num num))

(defn sum-of-squares [nums]
  (reduce + (map square nums)))

(defn square-of-sums [nums]
  (let [s (apply + nums)]
    (square s)))

(def numbers (range 1 101))

(- (square-of-sums numbers) (sum-of-squares numbers))

; using maths

(def limit 100)

(def sum (/ (* limit (inc limit)) 2))
(def sum_sq (/ (* limit (inc limit) (inc (* 2 limit))) 6))

(- (square sum) sum_sq)