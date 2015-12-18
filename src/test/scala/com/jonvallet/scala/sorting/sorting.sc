import java.util.Date
import com.jonvallet.scala.sorting._
import scala.collection.immutable.IndexedSeq
import scala.util.Random
val unsorted = List(2,9,4,2,1,3)
val expectedResult = List(1, 2, 2, 3, 4, 9)
assert(isSort(unsorted) == false)
assert(isSort(expectedResult) == true)
bubbleSort(unsorted)
assert(expectedResult == bubbleSort(unsorted))
val seq: IndexedSeq[Int] = (1 to 1000).map(_ => Random.nextInt())
val list: List[Int] = seq.toList
val currentTime2 = new Date()
imperativeBubbleSort(list)
new Date().getTime - currentTime2.getTime
val currentTime = new Date()
bubbleSort(list)
new Date().getTime - currentTime.getTime

