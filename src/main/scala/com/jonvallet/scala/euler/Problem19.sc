import java.time.{DayOfWeek, LocalDate}

var date = LocalDate.of(1901,1,1)

var result = 0

while (date.getYear < 2001) {
  if (date.getDayOfMonth == 1 && date.getDayOfWeek == DayOfWeek.SUNDAY)
    result = result +1
  date = date.plusDays(1)
}

result

def daysFrom(date: LocalDate): Stream[LocalDate] = date #:: daysFrom(date.plusDays(1))

daysFrom(LocalDate.of(1901,1,1)).takeWhile(_.getYear < 2001)
  .filter(_.getDayOfMonth == 1)
  .filter(_.getDayOfWeek == DayOfWeek.SUNDAY)
  .length


