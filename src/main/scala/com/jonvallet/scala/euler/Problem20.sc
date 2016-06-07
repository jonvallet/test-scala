def factorial(n: Int): BigInt = {
  (1 to n).map(BigInt(_)).reduce (_*_)
}

factorial(10)

def toStream(n: BigInt): List[Int] =
  if (n == 0)
    List()
 else
    (n % 10).toInt :: toStream(n/10)

factorial(100).toString.map(_.asDigit).sum

var result = factorial(100)
var sum = BigInt(0)

while (result > 0) {
  sum = sum + (result % 10)
  result = result /10
}

sum



