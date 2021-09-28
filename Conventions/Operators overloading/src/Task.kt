import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }
operator fun TimeInterval.times(amount: Int) : RepeatedTimeInterval
{
    return RepeatedTimeInterval(this, amount)
}
class RepeatedTimeInterval(val timeInterval: TimeInterval, val amount: Int)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval) : MyDate =
    addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.amount)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
