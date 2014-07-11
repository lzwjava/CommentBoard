(ns hello-ring.dao.db
  (require [clojure.java.jdbc :as jdbc]
           [clojure.data.json :as json]
           [hello-ring.utils.util :as util]))
(import java.util.Date)

(def db-spec
  {:classname   "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname     "//127.0.0.1:3306/sql_db"
   :user        "root"
   :password    "lizhiwei"})

(defn insert [name comment]
  (jdbc/insert! db-spec :comment
                {:name    name
                 :comment comment
                 :createdAt (util/currentTimeSecs)})) 

(defn get-all-comments
  []
  (let [res (jdbc/query db-spec
                        ["select * from comment order by createdAt desc"])]
    (json/write-str res)))

(defn get-comments
  [skip limit]
  (let [res (jdbc/query db-spec
                        ["select * from comment order by createdAt desc limit ?,?" skip limit])]
    res))

(defn delete-comment-by-id
  [id]
  (jdbc/execute! db-spec ["delete from comment where id=?" id]))

(defn update-comment-by-id [name comment id]
  (jdbc/execute! db-spec ["update comment set name=? , comment=? where id=?" name comment id]))

(defn get-comment-by-name
  [name]
  (let [res (jdbc/query db-spec
                        ["select * from comment where name=? order by createdAt desc" name])]
    res))
