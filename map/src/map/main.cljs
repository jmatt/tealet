(ns map.main
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [map.leaflet :as leaflet]))

(enable-console-print!)

; Application state
(def app-state (atom {}))

(defn booma-view [state owner]
  (reify
    om/IDidMount
    (did-mount [_]
      (let [-map (leaflet/init-map "map-view")]))
    om/IRender
    (render [_]
      (dom/div #js {:id "map-view"} nil))))

; add the root component
(om/root booma-view app-state
         {:target (.getElementById js/document "application")})
