val aList = List((2,3),(6,2),(2,1))
aList.map(x => (x._2, x._1))
aList.groupBy(_._1)

val l = List(2,3,4,2,5,6,6,5)


0 until 100 foreach { (i) => print(" " + (100 - i)) }

1 until 100 foreach {
  (i) => if (i % 15 == 0)
    print("FIZZBUZZ ")
    else if (i % 3 == 0)
    print("FIZZ ")
    else if (i % 5 == 0)
    print("BUZZ ")
    else
    print(i+" ")
}

def fizzbuzz(i: Int) = (i % 3, i % 5) match {
  case (0, 0) => "FIZZBUZZ"
  case (0, _) => "FIZZ"
  case (_, 0) => "BUZZ"
  case (_, _) => i
}
assert(fizzbuzz(3) == "FIZZ")
assert(fizzbuzz(5) == "BUZZ")
assert(fizzbuzz(15) == "FIZZBUZZ")
assert(fizzbuzz(4) == 4)

1 until 100 foreach (x => print(fizzbuzz(x)+" "))
