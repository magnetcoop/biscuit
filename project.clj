(defproject magnet/biscuit "1.1.1-SNAPSHOT"
  :description "Calculate message digests."
  :url "https://github.com/magnetcoop/biscuit"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :deploy-repositories [["snapshots" {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]
                        ["releases"  {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]]
  :plugins [[lein-cljfmt "0.6.2"]
            [jonase/eastwood "0.3.4"]])
