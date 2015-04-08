import com.jonvallet.scala.exercises.lists.MyList

def numbers(n: Int):Stream[Int] = n #:: numbers(n+1)

numbers(5) take 5 toList

val list = List(1,2,3,4,5,6)

val stream = MyList.combinations(2, list)
stream take 10 toList
val parameterList = List('a, 'b, 'c, 'd, 'e, 'f)
MyList.combinations(3, parameterList)