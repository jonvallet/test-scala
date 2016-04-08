import java.lang.Math.sqrt

def pythagorean(a: Int, b: Int): Double = sqrt(a*a + b*b)

def findPythagorean(p: Double): (Int, Int, Double) = {
  var a = 1
  var b = 2
  var c = pythagorean(a,b)

  while((a+b+c) != p) {
    if (b > c) {
      a += 1
      b = a + 1
    } else {
      b += 1
    }
    c = pythagorean(a,b)
  }
  (a,b,c)
}

val result = findPythagorean(1000.0)
(result._1 * result._2 * result._3).toLong



