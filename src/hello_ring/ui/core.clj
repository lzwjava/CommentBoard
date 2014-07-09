(ns hello-ring.ui.core
  (:import (java.lang Exception))
  (:use [ring.adapter.jetty :only [run-jetty]]
        [ring.util.response]
        [ring.middleware.file]
        [ring.middleware.resource]
        [ring.middleware.params]
        [ring.middleware.cookies]
        [ring.middleware.session]
        [ring.middleware.session.cookie])
  (:require [clojure.java.io :as io]
            [hello-ring.dao.db :as db]
            [net.cgrand.enlive-html :as html]))

(declare main-template server main-template1 main-template2)

(defn handler [request]
  (let [uri (:uri request)
        query-string (:query-string request)
        query-params (:query-params request)]
    (println uri)
    (if query-string
      (do
        (println "query-string do")
        (let [comment (get query-params "comment")
              name (get query-params "name")]
          (when (and comment
                     name)
            (db/insert comment name))))
      (main-template))))

(defn handler-request
  [request]
  (response (str request)))

(def app
  (-> handler wrap-params))

(try
  (.stop server)
  (catch Exception e))

;(def server (run-jetty app {:port 3004 :join? false}))

(html/deftemplate
  main-template "public/application.html"
  []
  [:head :title] (html/content "Enlive starter kit"))
