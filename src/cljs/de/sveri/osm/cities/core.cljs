(ns de.sveri.osm.cities.core
  (:require [re-frame.core :as re-frame]
            [reagent.core :as reagent]
            [de.sveri.osm.cities.events :as events]
            [de.sveri.osm.cities.config :as config]
            [de.sveri.osm.cities.views :as views]
            [de.sveri.osm.cities.routes :as routes]))




(defn dev-setup []
  (when config/debug?
    (set! *warn-on-infer* true)
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (routes/app-routes)
  (mount-root))
