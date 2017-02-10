val arr : Array[Array[Int]] = Array(Array(1,1,1),Array(1,1,1),Array(1,1,1))

def getSum(input : Array[Array[Int]], i : Int, j : Int): Int = {
  input(i-1)( j-1) + input(i-1)(j) + input(i-1)(j+1) + input(i)(j) + input(i+1)( j-1) + input(i+1)(j) + input(i+1)(j+1)
}

val result = getSum(arr, 1,1)

assert(result == 7)

val arr2 : Array[Array[Int]] = Array(Array(1,1,1,2),Array(1,1,1,2),Array(1,1,1,2), Array(1,1,1,1))

def getSums(input : Array[Array[Int]]) : Seq[Int] = {
  val m = input(0).length
  val n = input.length

  for {
    i <- 1 until m-1
    j <- 1 until n-1
  } yield getSum(input, i, j)
}

getSums(arr2).max




