(ns de.sveri.osm.cities.core
  (:require [de.sveri.osm.cities.components.components :refer [prod-system]]
            [clojure.tools.logging :as log]
            [system.repl :refer [set-init! start]])
  (:gen-class))

(defn -main [& args]
  (set-init! #'prod-system)
  (start)
  (log/info "server started."))
