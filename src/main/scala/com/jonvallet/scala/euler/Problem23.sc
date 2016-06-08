def sumProperDivisors (n: Int): Int = {
  (1 until n).filter(n % _ == 0).sum
}

val abundantNumbers = (1 to 28123).filter(n => sumProperDivisors(n) > n)

def isSummable(n: Int, numbers: Seq[Int]): Boolean = {
  if (numbers.head > n)
    false
  else {
    val iter = numbers.iterator
    val a = iter.next
    var next = a
    while (a + next < n) {
      next = iter.next
    }
    if (a + next == n) true else isSummable(n, numbers.tail)
  }
}

val result = (1 to 28123).filter(!isSummable(_, abundantNumbers)).sum
assert(4179871 == result)