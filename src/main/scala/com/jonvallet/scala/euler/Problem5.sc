import com.jonvallet.scala.euler._

import scala.annotation.tailrec

1*2*3*5*7*2*2*3*11*13*2*17*19

1*2*3*2*5*7*8*9*10*11*12*13*14*15*16*17*18*19*20

primes.takeWhile(_<9/2).toList

def getComponents(n: Long): List[Long] = n match {
  case 1 => List(1)
  case n => {
    val div = primes.takeWhile(_<=n).filter(p => n%p == 0).head
    div :: getComponents(n/div)
  }
}

getComponents(8)


