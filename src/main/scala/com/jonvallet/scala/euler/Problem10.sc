def isPrime(n: Long): Boolean = {
  if (n == 1) false
  else if (n < 4) true
  else if (n % 2 == 0) false
  else if (n < 9) true
  else if (n % 3 == 0) false
  else primes.takeWhile(p => p * p <= n).forall(n % _ > 0)
}

lazy val primes: Stream[Long] = 2L #:: Stream.iterate(3L)(_ + 1L).filter(isPrime)


primes.takeWhile(_ < 2000000).fold(0l)((a, b) => a + b)







