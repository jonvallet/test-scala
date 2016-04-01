import com.jonvallet.scala.euler.sum

lazy val fibs: Stream[Int] = 1 #:: 2 #:: fibs.zip(fibs.tail).map(n => n._1 +n._2)

val f10 = fibs.take(10).toList

sum(fibs.take(10).toList)

val fibsUnder4Million = fibs.takeWhile(n => n < 4000000)


sum(fibsUnder4Million.filter(n => n % 2 == 0))






