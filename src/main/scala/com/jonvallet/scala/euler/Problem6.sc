import com.jonvallet.scala.euler._

squareOfSums(1 to 10) - sumOfSquares(1 to 10)
squareOfSums(1 to 100) - sumOfSquares(1 to 100)


sum(1 to 10)

def sum2( range: Range) = {
  val n = range.last
  (n * (n +1))/2
}

sum2(1 to 10)
