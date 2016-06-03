def toWords(n: Int): String = n match {
  case 1 => "one"
  case 2 => "two"
  case 3 => "three"
  case 4 => "four"
  case 5 => "five"
  case 6 => "six"
  case 7 => "seven"
  case 8 => "eight"
  case 9 => "nine"
  case 10 => "ten"
  case 11 => "eleven"
  case 12 => "twelve"
  case 13 => "thirteen"
  case 14 => "fourteen"
  case 15 => "fifteen"
  case 16 => "sixteen"
  case 17 => "seventeen"
  case 18 => "eighteen"
  case 19 => "nineteen"
  case 20 => "twenty"
  case 30 => "thirty"
  case 40 => "forty"
  case 50 => "fifty"
  case 60 => "sixty"
  case 70 => "seventy"
  case 80 => "eighty"
  case 90 => "ninety"
  case 1000 => "onethousand"
  case a if a%100 == 0 => toWords(a/100)+"hundred"
  case a if a > 100 => toWords(a/100) + "hundredand" + toWords(a % 100)
  case a => toWords(a - a%10) + toWords(a % 10)

}

(1 to 5).map(toWords).foldLeft(0)((a,b) => a + b.length)
(1 to 1000).map(toWords).foldLeft(0)((a,b) => a + b.length)