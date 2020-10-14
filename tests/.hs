data Point = Point Float Float deriving (Show)
data Shape 
  = Circle Point Float 
  | Rectangle Point Point
  deriving (Show)

-- instance Show Shape where
--   show (Circle x y r) = printf "Circle %f %f %f" x y r
--   show (Rectangle x1 y1 x2 y2) = printf "Rectangle %f %f %f %f" x1 y1 x2 y2

area :: Shape -> Float
area (Circle _ r) = pi * r ^ 2
area (Rectangle (Point x1 y1) (Point x2 y2)) = (abs $ x2 - x1) * (abs $ y2 - y1)

nudge :: Shape -> Float -> Float -> Shape
nudge (Circle (Point x y) r) a b = Circle (Point (x + a) (y + b)) r
nudge (Rectangle (Point x1 y1) (Point x2 y2)) a b = Rectangle (Point (x1 + a) (y1 + b)) (Point (x2 + a) (y2 + b))

baseCircle :: Float -> Shape
baseCircle r = Circle (Point 0 0) r

baseRect :: Float -> Float -> Shape
baseRect width height = Rectangle (Point 0 0) (Point width height)

data Person = Person { firstName :: String
                     , lastName :: String
                     , age :: Int
                     , height :: Float
                     , phoneNumber :: String
                     , flavor :: String } deriving (Show)

data Vector a = Vector a a a deriving (Show)

vplus :: (Num a) => Vector a -> Vector a -> Vector a
(Vector a b c) `vplus` (Vector x y z) = Vector (a + x) (b + y) (c + z)

scalarProd :: (Num a) => Vector a -> Vector a -> a
(Vector a b c) `scalarProd` (Vector x y z) = (a * x) + (b * y) + (c * z)

vmult :: (Num a) => Vector a -> Vector a -> Vector a
(Vector a b c) `vmult` (Vector x y z) = Vector (a * x) (b * y) (c * z)

main = do
  let rectangle = Rectangle (Point 0 0) (Point 100 100)
  let circle = Circle (Point 0 0) 24
  let person = Person { firstName="John"
                      , lastName="Smith"
                      , age=25
                      , height=1.84
                      , phoneNumber="+12345678"
                      , flavor="chocolate"}

  print $ area rectangle
  print $ area circle

  print $ nudge circle 2.5 1.2
  print $ nudge rectangle 10 20

  print $ baseCircle 5
  print $ baseRect 15 5

  print $ nudge (baseRect 40 100) 60 23

  print person
