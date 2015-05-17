(ns challenge1
  (:use [clojure.test]))

(def zero (int \0))
(def letter-a (int \a))

(defn hex-to-decimal [s]
  (let [letter? #(>= (int %) letter-a)
        offset #(if (letter? %) (- letter-a 10) zero)
        to-decimal #(- (int %) (offset %))]
    (map (fn [[a b]] (+ (* a 16) b)) (partition 2 (map to-decimal s)))))

(defn hex-to-bytes [s]
  (let [decimals (hex-to-decimal s)]
    decimals))

(defn bytes-to-base64 [bs])

(defn hex-to-base64 [s]
  (->> s
       (hex-to-bytes)
       (bytes-to-base64)))

(is (= (hex-to-base64 "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d")
       "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"))

(hex-to-bytes  "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d")

