import com.jonvallet.scala.exercises.lists.MyList

val aList = List(1, "A", "C")

MyList.last(aList)
MyList.penultimate(aList)
MyList.nth(1, aList)
MyList.length(aList)

1 :: List(1,2,3)

val l2 = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

l2.groupBy((x) => x)

l2.groupBy((x) => x).map((x)=>(x._2.length,x._1)).toList

l2.span(_ == 'a)

val l3 = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

l3.flatMap(e => List.fill(e._1)(e._2))

MyList.drop(5,l2)

l2.last :: l2.take(l2.length -1)
