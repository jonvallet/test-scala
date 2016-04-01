import com.jonvallet.scala.euler.sum

val list = 1 until 10

def f(a: Int) = a % 3 == 0 || a % 5 == 0

val l1 = list.filter(f)


sum(l1)

lazy val l2 = 1 until 1000 filter f

sum(l2)

