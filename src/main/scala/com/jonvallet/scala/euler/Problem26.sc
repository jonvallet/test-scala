def getRecurringCircleLength(n: Int): Int = {
  var mod = 1 % n
  var cache: Map[Int, Int] = Map()
  var i = 0

  while (mod != 0 && !cache.contains(mod)) {
    i = i + 1
    cache += (mod -> i)
    mod =  mod*10%n
  }

  if (mod == 0)
    1
  else {
    i - cache(mod) +1
  }
}

val result = (1 to 1000).map(a => (a, getRecurringCircleLength(a))).reduce((a,b)=> if (a._2 > b._2) a else b)
println(s"The ${result._1} is the longer reciprocal cycle with ${result._2} digits.")
