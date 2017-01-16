(ns random-ellipse.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup [])

(defn update-state [])

(defn draw-state []
  ; Set circle color.
  (q/fill 50)

  (if (q/mouse-pressed?)
    (q/ellipse (q/mouse-x) (q/mouse-y) (rand-int 80) (rand-int 80))))

(q/defsketch random-ellipse
  :title "Random circles at your finger tips"
  :size [500 500]
  ; setup function called only once, during sketch initialization.
  :setup setup
  ; update-state is called on each iteration before draw-state.
  :update update-state
  :draw draw-state
  :features [:keep-on-top])
