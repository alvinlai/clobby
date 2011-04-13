(ns clobby.core
  (:use compojure.core
        hiccup.core
        ring.middleware.reload-modified)
  (:require 
    [appengine-magic.core :as ae]
    [appengine-magic.services.datastore :as ds]))

(defn default-layout
  "Renders default layout"
  [body]
  (html
    [:div#content body]))

(defroutes clobby-app-handler 
  (GET "/wee" _
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body "Hello, world!"})
  (GET "/" _
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body (default-layout "Awesome!")}))


(ae/def-appengine-app clobby-app #'clobby-app-handler)