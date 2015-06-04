(ns map.leaflet)


(def tile-layer-url "http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png")

(def tile-layer-params {
                        :attribution "Map data &copy; OpenStreet maps"
                        :maxZoom 18
                        })

(defn init-tile-layer []
  (-> js/L
      (.tileLayer tile-layer-url tile-layer-params)))

(defn init-map [element-id]
  (let [tile-layer (init-tile-layer)]
      (-> js/L
          (.map element-id)
          (.setView #js [25. 25.] 5)
          (.addLayer tile-layer))))
