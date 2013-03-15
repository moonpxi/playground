(use 'commons)
(use 'clojure.test)

(defn converge [fracs]
  (let [as (reverse fracs)]
    (loop [c (first as) remas (rest as)]
      (let [a (first remas)]
        (if (nil? a)
          c
          (recur (+ a (/ 1 c)) (rest remas)))))))

(is (= (/ 3 2) (converge [1 2])))
(is (= (/ 41 29) (converge [1 2 2 2 2])))
