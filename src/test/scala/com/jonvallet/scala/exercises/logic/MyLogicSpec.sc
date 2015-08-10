import com.jonvallet.scala.exercises.logic.S99Logic._
import com.jonvallet.scala.exercises.logic._

val truthMap = Map( (true, true) -> true, (true, false) -> true, (false, true) -> false, (false, false) -> false)

truthMap(true, false)

table2((a: Boolean, b: Boolean) => and(a, or(a,b)))