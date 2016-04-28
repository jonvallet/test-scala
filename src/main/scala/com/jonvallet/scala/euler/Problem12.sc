import java.util.Date
import com.jonvallet.scala.euler._

def triangleNumber(n: Long): Long = (1L to n).fold(0L)((a,b) => a+b)

assert(triangleNumber(7) == 28)
assert(triangleNumber(8) == 36)

primes.take(10).toList

def factors(n: Long): Int = {
  (1L to Math.sqrt(n).toInt).filter(n % _ == 0).length * 2
}
//def factors(n: Long): Seq[Long] = (1L to n).filter(n%_==0)


factors(120)
factors(15)
factors(28)

val triangles = Stream.iterate(1L)(_ +1L).map(n =>{
  val t = triangleNumber(n)
  (t,factors(t))
})

triangles.take(20).toList
triangles.filter(_._2 > 5).head

def getGreaterTriangleNumberFunc(d: Int): Long =
  triangles.filter(_._2 > d).head._1

getGreaterTriangleNumberFunc(5)
getGreaterTriangleNumberFunc(10)

val now2 = new Date()
getGreaterTriangleNumberFunc(100)
new Date().getTime - now2.getTime

val now = new Date()
getGreaterTriangleNumberFunc(150)
new Date().getTime - now.getTime

val now3 = new Date()
getGreaterTriangleNumberFunc(500)
new Date().getTime - now3.getTime






