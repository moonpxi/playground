(ns sudoku-solver.solver-test
  (:require [clojure.test :refer :all]
            [sudoku-solver.puzzle-helper :refer :all]
            [sudoku-solver.solver :refer :all]))

(def initial-puzzle
  (puzzle [1 _ _ 9 2 _ _ _ _]
          [5 2 4 _ 1 _ _ _ _]
          [_ _ _ _ _ _ _ 7 _]
          [_ 5 _ _ _ 8 1 _ 2]
          [_ _ _ _ _ _ _ _ _]
          [4 _ 2 7 _ _ _ 9 _]
          [_ 6 _ _ _ _ _ _ _]
          [_ _ _ _ 3 _ 9 4 5]
          [_ _ _ _ 7 1 _ _ 6]))

(def solution
  (puzzle [1 7 6 9 2 3 5 8 4]
          [5 2 4 8 1 7 6 3 9]
          [8 9 3 6 5 4 2 7 1]
          [9 5 7 3 4 8 1 6 2]
          [6 3 8 1 9 2 4 5 7]
          [4 1 2 7 6 5 3 9 8]
          [2 6 5 4 8 9 7 1 3]
          [7 8 1 2 3 6 9 4 5]
          [3 4 9 5 7 1 8 2 6]))

(deftest solving
  (is (= solution (solve initial-puzzle))))

