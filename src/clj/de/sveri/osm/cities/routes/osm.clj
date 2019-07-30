(ns de.sveri.osm.cities.routes.osm
  (:require [compojure.core :refer [routes GET]]
            [ring.util.response :refer [response status]]
            [de.sveri.osm.cities.db.osm :as db-osm]
            [clojure.string :as str]))


(defn get-cities [config db req apikey search-term]
  (if (= apikey (:rest-api-key config))
    (do
      (if (str/blank? search-term)
        (status (response {:error "Search Term cannot be empty"}) 500)
        (do
          (response {:cities (db-osm/get-cities-by-name db search-term)}))))
    (status (response {:error "Wrong Api Key"}) 403)))

(defn osm-routes [config db]
  (routes (GET "/cities" [apikey search-term req] (get-cities config db req apikey search-term))))
