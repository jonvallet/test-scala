import com.jonvallet.scala.sorting._
val unsorted = List(2,9,4,2,1,3)
val expectedResult = List(1, 2, 2, 3, 4, 9)

assert(isSort(unsorted) == false)
assert(isSort(expectedResult) == true)
bubbleSort(unsorted)
assert(expectedResult == bubbleSort(unsorted))