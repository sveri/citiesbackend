(ns de.sveri.osm.cities.db.osm
  (:require [clojure.java.jdbc :as j]
            [clojure.string :as str]))

(defn get-cities-by-name [db name]
  (j/query db ["select id, nodes_id, name, is_in, country, continent from cities where lower_name LIKE ?"
               (str (str/lower-case name) "%")]))
