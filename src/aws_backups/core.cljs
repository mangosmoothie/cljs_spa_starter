(ns aws-backups.core
  (:require [reagent.core :as r]))


(defn dir-list [dirs]
  [:div
   [:ul
    (map (fn [d] [:li {:key d} d]) @dirs)]])


(defn add-dir [dirs new-dir]
  [:div
   [:input {:type      "text"
            :value     @new-dir
            :on-change #(reset! new-dir (-> % .-target .-value))}]
   [:button {:on-click #(swap! dirs conj @new-dir)} "add"]])


(defn dir-section [dirs]
  (let [new-dir (r/atom "abc")]
    (fn []
      [:div
       [:p "the val is " @new-dir]
       [add-dir dirs new-dir]
       [dir-list dirs]])))


(r/render [dir-section (r/atom [])] (.getElementById js/document "app"))
