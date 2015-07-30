import com.jonvallet.scala.exercises.arithmetic.MyArithmetic._

val elementsToTake = Math.sqrt(7).toInt + 1
val primeList = primes take elementsToTake toList

primes take 1000 toList

primeList contains 7

val list = List(1,2,4,2,5,3)

val result = List(3, 3, 5, 7).groupBy(a => a).map {case (k,v) => (k, v.length)}.toList

list.sorted

result.sortBy(_._1)

1 to 5

1 until 5

val first = 7
val last = 31

primes.dropWhile(_<first).takeWhile(_<=last).toList