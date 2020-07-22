import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate =
        this.addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval): MyDate =
        addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)

operator fun TimeInterval.times(number: Int) =
        RepeatedTimeInterval(this, number)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
