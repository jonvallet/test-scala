import com.jonvallet.scala.exercises.arithmetic.MyArithmetic._

val elementsToTake = Math.sqrt(7).toInt + 1
val primeList = primes take elementsToTake toList

primeList contains 7