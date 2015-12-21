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
def getRandomList = {
  val seq: IndexedSeq[Int] = (1 to 10000).map(_ => Random.nextInt())
  seq.toList
}
def executeSort(f: (List[Int]) => List[Int]) = {
  val list = getRandomList
  val currentTime = new Date()
  f(list)
  new Date().getTime - currentTime.getTime
}
executeSort(imperativeBubbleSort)
executeSort(insertionSort)
executeSort(treeSort)

