def getPermutations(l: List[Int]): List[List[Int]] = l match {
  case a :: b :: Nil => List(List(a,b) ,List(b,a))
  case _ =>
    for {
      e <- l
      perm <- getPermutations(l.filterNot(_ == e))
    } yield e :: perm
}

val list = List(0,1,2,3,4,5,6,7,8,9)

def getNextPermutation(l: List[Int]): List[Int] = {
  val v = l.toArray

  var i = l.length -1

  while (i > 0 && v(i) < v(i-1)) i = i -1

  val p: Int = v(i-1)
  val tail = l.takeRight(l.length -i+1).sorted
  val x: Int = tail.filter(_>v(i-1)).min

  val tailNorm = l.takeRight(l.length-i).map(a => if (a == x) p else a)

  l.take(i-1) ++ List(x) ++ tailNorm.sorted
}

def permutation(elem: List[Int]): Stream[List[Int]] = elem #:: permutation(getNextPermutation(elem))

val r = permutation(list).take(1000000).last
assert(List(2,7,8,3,9,1,5,4,6,0) == r)

getPermutations(list).take(1000000).last

