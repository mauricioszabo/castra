(ns wigwam-clj.foo
  (:require
    [wigwam-clj.rules   :as r]
    [wigwam-clj.request :as rpc]))

(rpc/defn login
  "This is a doc comment."
  [user pass]
  {:rpc [(r/login! user pass)]
   :pre [(not= user "omfg")]}
  "Congratulations, you're logged in.")

(rpc/defn ^:rpc-test1 logout
  "Hello world."
  []
  {:rpc [(r/logout!)]}
  "Congratulations, you're logged out.")

(rpc/defn test1
  "The rain in spain falls mainly on the plain."
  [x y]
  {:rpc [(r/logged-in?)]}
  (+ x y))

(rpc/defn test2 [x y]
  {:rpc [(r/deny)]}
  (- x y))

(rpc/defn test3 [x y]
  {:rpc [(r/allow)]}
  (test2 x y))
