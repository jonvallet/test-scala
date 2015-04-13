import scala.annotation.tailrec

val aString = "hello"

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

assert (reverse(aString) == "olleh")