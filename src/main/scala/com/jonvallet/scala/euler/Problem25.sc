lazy val fibs: Stream[BigInt] = BigInt(0) #::
  BigInt(1) #::
  fibs.zip(fibs.tail).map { n => n._1 + n._2 }

val indexPrevious = fibs.takeWhile(_.toString.length < 1000).zipWithIndex.last._2

assert(indexPrevious+1 == 4782)



