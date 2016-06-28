
val aString = "ola"

def reverse(s: String) = {
  val list = s.toList
  
  def reverseRec(l: List[Char]): List[Char] = l match {
    case Nil => Nil
    case head :: Nil => List(head)
    case head :: tail => reverseRec(tail) ++ List(head)
  }

  reverseRec(s.toList).mkString

}

reverse(aString)

assert (reverse(aString) == "alo")

def reverse2(s: String): String = {
  val l = s.length
  val result = new Array[Char](l)

  for (i <- 0 until l) result(i) = s(l-1-i)

  result.mkString

}

reverse2("ola")
