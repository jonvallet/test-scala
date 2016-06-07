val tree = "75\n95 64\n17 47 82\n18 35 87 10\n20 04 82 47 65\n19 01 23 75 03 34\n88 02 77 73 07 63 67\n99 65 04 28 06 16 70 92\n41 41 26 56 83 40 80 70 33\n41 48 72 33 47 32 37 16 94 29\n53 71 44 65 25 43 91 52 97 51 14\n70 11 33 28 77 73 17 78 39 68 17 57\n91 71 52 38 17 14 91 43 58 50 27 29 48\n63 66 04 68 89 53 67 30 73 16 69 87 40 31\n04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"
val data = tree.split("\\n").map(_.split(" ").map(_.toInt))

def reduceTriangle (t: Array[Array[Int]]):Array[Array[Int]] = {
  val previousRow = t(t.length-2)
  val lastRow = t(t.length-1)
  var newRow = Array[Int]()

  for (i <- 0 until t.length-1) {
    if (lastRow(i) > lastRow(i+1)) {
      newRow = newRow  :+ lastRow(i) + previousRow(i)
    } else {
      newRow = newRow :+ lastRow(i+1) + previousRow(i)
    }
  }
  t.take(t.length-2) :+ newRow
}

def getMaxRoute(t: Array[Array[Int]]): Int = {
  var result = t
  while (result.length > 2) result = reduceTriangle(result)
  result(1).max + result(0)(0)
}

getMaxRoute(data)