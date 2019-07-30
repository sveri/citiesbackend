(ns de.sveri.osm.cities.user
  (:require [de.sveri.osm.cities.components.components :refer [dev-system]]
            [system.repl :refer [system set-init! start stop reset]]))

(defn startup []
  (set-init! #'dev-system)
  (start))
