def sumProperDivisors (n: Int): Int = {
  (1 until n).filter(n % _ == 0).sum
}

def amicablePairs(limit: Int) = for {
  i <- 1 to limit
  n = sumProperDivisors(i)
  m = sumProperDivisors(n)
  if (i == m && n != m)
}yield(n)

amicablePairs(10000).sum
