(ns hello-ring.dao.db
  (require [clojure.java.jdbc :as jdbc]))

(def db-spec
  {:classname   "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname     "//127.0.0.1:3306/sql_db"
   :user        "root"
   :password    "lizhiwei"})

(defn insert [name comment]
  (jdbc/insert! db-spec :comment
                {:name    name
                 :comment comment}))
