fun main() {
    println(convertTime(30))
    println(convertTime(90))
    println(convertTime(360))
    println(convertTime(3600))
    println(convertTime(7200))
    println(convertTime(172_800))
    println(convertTime(1_209_600))
    println(convertTime(7_257_600))
    println(convertTime(29_030_400))
    println(convertTime(65_318_400))
    println(convertTime(326_592_000))
}

fun convertTime(publishedAgo: Int): String {
    fun convertYears(months: Int): String {
        val years: Double = months.toDouble() / 12

        return when {
            (years == 1.0) -> "год назад"
            (years < 2) -> "более года назад"
            (years == 2.0) -> "2 года назад"
            (years < 3) -> "более 2 лет назад"
            (years == 3.0) -> "3 года назад"
            (years < 4) -> "более 3 лет назад"
            (years == 4.0) -> "4 года назад"
            (years < 5) -> "более 4 лет назад"
            (years == 5.0) -> "5 лет назад"
            else -> "более 5 лет назад"
        }
    }
    
    fun convertMonths(weeks: Int): String {
        val months: Int = weeks / 4

        if (months < 12) {
            val monthsCase: String = when {
                (months < 5) -> "месяца"
                else -> "месяцев"
            }

            return if (months == 1) "месяц назад" else "$months $monthsCase назад"
        }

        return convertYears(months)
    }

    fun convertWeeks(days: Int): String {
        val weeks = days / 7

        if (weeks < 4) {
            return if (weeks == 1) "неделю назад" else "$weeks недели назад"
        }

        return convertMonths(weeks)
    }

    fun convertDays(hours: Int): String {
        val days = hours / 24

        if (days < 7) {
            val daysCase: String = when {
                (days == 1) -> "день"
                (days == 2 || days == 3 || days == 4) -> "дня"
                else -> "дней"
            }

            return "$days $daysCase назад"
        }

        return convertWeeks(days)
    }

    fun convertHours(minutes: Int): String {
        val hours = minutes / 60

        if (hours < 24) {
            val hoursCase: String = when {
                (hours == 21) -> "час"
                (hours == 2 || hours == 3 || hours == 22 || hours == 23 || hours == 4) -> "часа"
                else -> "часов"
            }

            if (hours == 1)
                return "час назад"

            return "$hours $hoursCase назад"
        }

        return convertDays(hours)
    }

    fun convertMinutes(seconds: Int): String {
        // minutes
        val minutes: Int = seconds / 60

        if (minutes < 60) {
            if (minutes == 0)
                return "менее минуты назад"
            else if (minutes < 60) {
                val minutesCase: String = when {
                    (minutes % 10 == 1 && minutes != 11) -> "минуту"
                    ((minutes % 10 == 2 || minutes % 10 == 3 || minutes % 10 == 4) &&
                            (minutes != 12) && (minutes != 13) && (minutes != 14)) -> "минуты"
                    else -> "минут"
                }

                if (minutes == 1)
                    return "минуту назад"

                return "$minutes $minutesCase назад"
            }
        }

        return convertHours(minutes)
    }

    return convertMinutes(publishedAgo)
}
