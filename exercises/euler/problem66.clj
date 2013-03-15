(use 'commons)
(use 'clojure.test)

(defn perfect-square? [n]
  (let [s (Math/sqrt n)]
    (no-decimal? s)))

(defn solve-dio [d]
  (if (perfect-square? d)
    nil
    (first (for [x (iterate inc 2)
                 :let [y (sqrt (/ (dec (pow2 x)) d))] 
                 :when (no-decimal? y)]
             [x (int y)]))))

(is (nil? (solve-dio 4)))
(is (= [9 4] (solve-dio 5)))

(println (map (comp first solve-dio) [2 3 5 6 7]))

;(time (println (solve-dio 61)))

(doseq [i (range 62 1001)]
  (println i (solve-dio i)))

(println (->>
           (range 2 7)
           (map (comp first solve-dio))
           (sort)
           (last)))
