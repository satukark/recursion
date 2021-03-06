(ns recursion)

(defn product [coll]
  (if (empty? coll) 1
    (* (first coll)
       (product (rest coll)))))

(defn singleton? [coll]
  (if (empty? coll) false
  (empty? (rest coll))))

(defn my-last [coll]
 (if (empty? coll) nil
 (if (singleton? coll)
     (first coll)
     (my-last (rest coll)))))

(defn max-element [a-seq]
  (if (empty? a-seq) nil
  (if (singleton? a-seq)
     (first a-seq)
     (max (first a-seq) (max-element (rest a-seq))))))

(defn seq-max [seq-1 seq-2]
  (if (> (count seq-1) (count seq-2))
  seq-1 seq-2))

(defn longest-sequence [a-seq]
  (if (empty? a-seq) nil
  (seq-max (first a-seq) (longest-sequence (rest a-seq)))))

(defn my-filter [pred? a-seq]
 (cond (empty? a-seq) ()
 (pred? (first a-seq)) (cons (first a-seq) (my-filter pred? (rest a-seq)))
  :else (my-filter pred? (rest a-seq))))

(defn sequence-contains? [elem a-seq]
  (cond (empty? a-seq) false
  (= (first a-seq) elem) true
  :else (sequence-contains? elem (rest a-seq))))

(defn my-take-while [pred? a-seq]
 (cond (empty? a-seq) ()
 (pred? (first a-seq)) (cons (first a-seq) (my-take-while pred? (rest a-seq)))
 :else ()))

(defn my-drop-while [pred? a-seq]
  (cond (empty? a-seq) ()
  (pred? (first a-seq)) (my-drop-while pred? (rest a-seq))
  :else a-seq))

(defn seq= [a-seq b-seq]
  (cond
    (and (empty? a-seq) (empty? b-seq)) true
    (not (= (first a-seq) (first b-seq))) false
    (or (empty? a-seq) (empty? b-seq)) false
    :else (seq= (rest a-seq) (rest b-seq))))

(defn my-map [f seq-1 seq-2]
  (if (or (empty? seq-1) (empty? seq-2))()
  (cons (f (first seq-1) (first seq-2)) (my-map f (rest seq-1) (rest seq-2)))))

(defn power [n k]
  (if (zero? k)
    1
    (* n (power n (- k 1)))))

(defn fib [n]
  (cond
  (= n 0) 0
  (= n 1) 1
  :else (+ (fib ( - n 1)) (fib (- n 2)))))

(defn my-repeat [how-many-times what-to-repeat]
  (if (<= how-many-times 0)
   ()
   (cons what-to-repeat (my-repeat (- how-many-times 1) what-to-repeat))))

(defn my-range [up-to]
  (if (<= up-to 0)
  ()
  (cons (- up-to 1) (my-range (- up-to 1)))))

(defn tails [a-seq]
  (if (empty? a-seq) '(())
  (cons (seq a-seq) (tails (rest a-seq)))))

(defn inits [a-seq]
  (if (empty? a-seq) '(())
  (reverse (map reverse (tails (reverse a-seq))))))

(defn rotations [a-seq]
  (if (empty? a-seq) '(())
    (map concat (rest (tails a-seq))
                (rest (inits a-seq)))))

(defn my-frequencies-helper [freqs a-seq]
  [:-])

(defn my-frequencies [a-seq]
  (my-frequencies-helper {} a-seq))

(defn un-frequencies [a-map]
  [:-])

(defn my-take [n coll]
  (if (or (empty? coll) (= 0 n)) ()
  (cons (first coll) (my-take (- n 1) (rest coll)))))

(defn my-drop [n coll]
  (cond (empty? coll) ()
        (= 0 n) (seq coll)
  :else (my-drop (- n 1) (rest coll))))

(defn halve [a-seq]
  (let [half (int (/ (count a-seq) 2))]
  (vector (my-take half a-seq) (my-drop half a-seq))))

(defn seq-merge [a-seq b-seq]
  (cond (empty? a-seq) (seq b-seq)
        (empty? b-seq) (seq a-seq)
        (<= (first a-seq) (first b-seq)) (cons (first a-seq) (seq-merge (rest a-seq) b-seq))
  :else (cons (first b-seq) (seq-merge a-seq (rest b-seq)))))

(defn merge-sort [a-seq]
  [:-])

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])

