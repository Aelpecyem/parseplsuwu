(ns parseplsuwu.core)

(defn get-value
  "Returns the integer value of a bottom specs character"
  [code]
  (case code
    ":people_hugging:" 200
    ":sparkling_heart:" 50
    ":sparkles:" 10
    ":pleading_face:" 5
    "," 1
    0))

(defn eval-unicode
  "Returns a unicode character from a sequence of bottom specs characters"
  [input]
  (char (reduce + (map get-value
    (re-seq 
      #":people_hugging:|:sparkling_heart:|:sparkles:|:pleading_face:|,|:heart:" 
      input)))))

(defn split-input
  "Splits the input string by its byte seperator 👉👈"
  [input]
  (.split input ":point_right::point_left:"))

(defn -main
  "Deserialize bottom specs,,, pls,,, (currently using discord emoji names because i am lazy)"
  [input]
  (prn (clojure.string/join 
      (map eval-unicode (split-input input)))))