import scala.annotation.tailrec

val stockPricesYesterday = List(10, 7, 5, 8, 11, 9)

def getMaxBenefit(prices: List[Int]) = {
  @tailrec
  def getMaxBenefitRec(minValue: Int, maxBenefit: Int,prices: List[Int]): Int = prices match {
    case Nil => throw new IllegalArgumentException
    case head :: Nil => Math.max(head - minValue, maxBenefit)
    case head :: tail => getMaxBenefitRec(Math.min(minValue, head), Math.max(head - minValue, maxBenefit), tail)
  }
  getMaxBenefitRec(prices.head, 0, prices.tail)
}

assert(6 == getMaxBenefit(stockPricesYesterday))