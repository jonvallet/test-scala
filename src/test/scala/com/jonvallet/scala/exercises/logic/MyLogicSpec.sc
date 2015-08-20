import com.jonvallet.scala.exercises.logic.S99Logic._
import com.jonvallet.scala.exercises.logic._

val truthMap = Map( (true, true) -> true, (true, false) -> true, (false, true) -> false, (false, false) -> false)

truthMap(true, false)

val truthMap2 = table2((a: Boolean, b: Boolean) => and(a, or(a,b)))

val list = for {
  entry <- truthMap2
  a = entry._1._1
  b = entry._1._2
  c = entry._2
}yield (a,b,c)

val a = true
val b = false

println(f"$a%-5s $b%-5s")
list.mkString("\n")
print(truthMap2)
