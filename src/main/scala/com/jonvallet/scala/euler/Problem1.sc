val list = 1 until 10

def f(a: Int) = a % 3 == 0 || a % 5 == 0

val l1 = list.filter(f)

def sum(l: Seq[Int]) = l.fold(0)((a, b) => a + b)

sum(l1)

lazy val l2 = 1 until 1000 filter f

sum(l2)

