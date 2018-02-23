def fib(n: Int): Int = if (n == 1 || n == 2) 1 else fib(n-1) + fib(n-2)

assert(fib(6) == 8)

lazy val fibonacci: Stream[Int] = Stream.from(1).map(fib)

fibonacci.take(10).toList

fibonacci.filter(_%2 == 0).take(10).toList

val list = List(1,2,3)
val list2 = 4 :: list
println(list)
println(list2)

val data = Map("name"->"Jon","surname"->"Vallet")
data.map(e => if (e._1 == "name") e._1 -> "Maria" else e)


