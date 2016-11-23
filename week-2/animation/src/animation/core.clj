(ns animation.core
  (:require [quil.core :refer :all]))

(defn setup []
  (smooth))

(defn draw []
  (background 255)
  (no-stroke)
  
  ; Lets show the frame count on the screen!
  (fill 0)
  (text (str "(frame-count) = " (frame-count))
    5 190)
  ;(text (str "(mod (frame-count) 230) = " (mod (frame-count) 230))
  ;  5 190)
  
  ; First red ball
  ; Here's how this animation would look if you plot it out:
  ; https://www.wolframalpha.com/input/?i=mod(x,+230)
  (fill 255 0 0)
  (ellipse (- (mod (frame-count) 230) 15) 35 30 30)
  
  
  ; Second blue rectangle twice as fast
  (fill 0 0 255)
  (rect (- (mod (* (frame-count) 2) 230) 15) 70 30 30)
  
  
  ; Bonus: Swinging icecream
  ; https://www.wolframalpha.com/input/?i=sin(x%2F20)*40%2B90
  (with-translation [(+ (* (sin (/ (frame-count) 20)) 40) 90)
                     130] 
    (fill 255 0 0)
    (triangle 0 0 27 0 13 30)
    (fill 255 20 147)
    (ellipse 8 0 20 20)
    (fill 186 85 211)
    (ellipse 19 0 20 20)))
  

(defsketch example
  :title "Animation Example"
  :setup setup
  :draw draw
  :size [200 200])

(defn -main [& args])
