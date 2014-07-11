(ns hello-ring.utils.util)

(defn currentTimeSecs []
  (int (/ (System/currentTimeMillis) 1000)))
