val list = List("one", "two", "three")

val map = list.zipWithIndex.toMap

map.get("two")

val abcValues = "abcdefghijklmnopqrstuvwxyz".zipWithIndex.map(a => (a._1 , (a._2+1))).toMap

abcValues('z')

"COLIN".toLowerCase.map(abcValues(_)).sum

//def worth(word: String): Int = word.map(a => abcValues.get(_)).sum


