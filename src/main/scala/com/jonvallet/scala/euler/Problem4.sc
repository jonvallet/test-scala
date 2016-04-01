import com.jonvallet.scala.euler._

isPalindrome("9009")

isPalindrome("9001")

val palindromes = getPalindromes(99)

getMax(palindromes)

val p2 = getPalindromes(999)

val result = getMax(p2)

s"${result._1 * result._2} = ${result._1} x ${result._2}"
