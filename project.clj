(defproject hello-ring "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [ring/ring-core "1.3.0"]
                           [korma "0.3.0-RC5"]
                           [org.clojure/java.jdbc "0.3.3"]
                           [org.xerial/sqlite-jdbc "3.7.2"]
                           [ring/ring-jetty-adapter "1.3.0"]
                           [mysql/mysql-connector-java "5.1.25"]
                           [enlive "1.1.5"]
                           [compojure "1.1.8"]]
            :plugins [[lein-ring "0.8.7"]]
            :ring {:handler hello-ring.ui.core/app})
