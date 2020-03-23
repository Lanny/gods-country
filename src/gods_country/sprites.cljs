(ns ^:figwheel-hooks gods-country.sprites
  (:require
   [goog.dom :as gdom]
   [goog.string :as gstring]
   [goog.string.format]))

(def sprite-names
  ["player"
   "grass"])

(def sprites 
  (into {}
        (map (fn [sprite-name] 
               (let [img (js/Image.)]
                 (set! (.-src img) (str "sprites/" sprite-name ".png"))
                 [(keyword sprite-name) img]))
               sprite-names)))
