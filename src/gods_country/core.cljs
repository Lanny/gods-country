(ns ^:figwheel-hooks gods-country.core
  (:require
   [goog.dom :as gdom]
   [gods-country.sprites :as sprites]))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn fill-rect! [ctx color x y w h]
    (set! (.-fillStyle ctx) color)
    (.fillRect ctx x y w h))

(defn main []
  (let [canvas (gdom/getElement "gc-main")
        ctx (.getContext canvas "2d")]
    (fill-rect! ctx "white" 0 0 500 500)
    (fill-rect! ctx "green" 10 10 100 100)
    (.drawImage ctx (:player sprites/sprites) 50 50)))

(main)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
