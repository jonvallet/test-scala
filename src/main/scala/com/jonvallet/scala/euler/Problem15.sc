def factorial(n: BigInt): BigInt = {
  if (n == BigDecimal(1)) n else n * factorial(n-1)
}

def permutationWithoutRepetition(n: Long, elem: List[Long]) = {
  val sumOfFactorialProductsElements = elem.map(a => factorial(BigInt(a))).fold(BigInt(1))((a,b) => a*b)
  factorial(n)/sumOfFactorialProductsElements
}

permutationWithoutRepetition(40, List(20,20))

var map: Map[(Long, Long), Long] = Map()

def countRoutes(m: Long, n: Long): Long=
  if (n == 0 || m == 0)
    1
  else map.get((m,n)) match {
    case Some(v) => v
    case None =>
      val value =  countRoutes(m, n-1) + countRoutes(m-1, n)
      map = map ++ Map((m,n) -> value)
      value
  }

countRoutes(20,20)