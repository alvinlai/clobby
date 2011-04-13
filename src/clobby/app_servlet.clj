(ns clobby.app_servlet
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:use clobby.core)
  (:use [appengine-magic.servlet :only [make-servlet-service-method]]))


(defn -service [this request response]
  ((make-servlet-service-method clobby-app) this request response))
