(ns drawing.core
  (:require [quil.core :refer :all]))

(defn setup []
  (frame-rate 30)
  (color-mode :rgb)
  (stroke 255 0 0))

(def my-width 400)
(def my-height 400)

(defn set-color [mx my]
  ; set color according to the mouse position
  ; lines
  (stroke (abs (- mx 255))
          (abs (- my 255))
          (abs (/ (+ mx my) 2)))
  ; rectangle
  (fill (abs (- mx 255))
        (abs (- my 255))
        (abs (/ (+ mx my) 2))))
  
(defn size-rect [x y my-size]
   (rect (- x (/ my-size 2)) (- y (/ my-size 2)) my-size my-size))

(defn perspective-rec []
  ; rectangle connected to the corners of the screen
  (let [x (mouse-x)
        y (mouse-y)
        my-size (/ y 2)]
   (line 0 0  (- x (/ my-size 2)) (- y (/ my-size 2)))
   (line my-width 0 (+ x (/ my-size 2)) (- y (/ my-size 2)))
   (line 0 my-height (- x (/ my-size 2)) (+ y (/ my-size 2)))
   (line my-width my-height (+ x (/ my-size 2)) (+ y (/ my-size 2)))
  ; rectangle that changes its size according to the mouse position
   (size-rect x y my-size)))

(defn draw []
  (background 0)
  (set-color (mouse-x) (mouse-y))
  (perspective-rec))



(defsketch hello-lines
  :title "Responsive-Rainbow-Rectangle"
  :size [400 400]
  :setup setup
  :draw draw)
