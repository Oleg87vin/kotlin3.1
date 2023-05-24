const val now = 60
const val oneMinutes = 60 * 60
const val exactHour = 60 * 60 * 24
const val yesterday = 60 * 60 * 24 * 2
const val afterYesterday = 60 * 60 * 24 * 3
const val longTime = 60 * 60 * 24 * 4

fun main() {
    var time = 0
    println("Ведите количество секунд")
    time = readln().toInt()
    println("Пользователь был(а) в сети ${agoToText(time)} ")

}

fun agoToText(time: Int): String = when {
    time!! <= now -> "только что"
    time!! <= oneMinutes -> minutes(time)
    time!! <= exactHour -> hours(time)
    time!! <= yesterday -> "вчера"
    time!! <= afterYesterday -> "позавчера"
    time!! <= longTime -> "давно"
    else -> "давно"
}

fun minutes(seconds: Int): String {
    val minutes: Int = seconds / 60

    val wordOut: String = when {
        minutes in 5..20 -> "минут"
        minutes % 10 == 1 -> "минуту"
        minutes % 10 in 2..4 -> "минуты"
        else -> {
            "минут"
        }
    }
    return "$minutes $wordOut назад"
}

fun hours(seconds: Int): String {
    val hours: Int = seconds / 3600

    val wordOut: String = when {
        hours in 5..20 -> "часов"
        hours % 10 == 1 -> "час"
        hours % 10 in 2..4 -> "часа"
        else -> "часов"
    }
    return "$hours $wordOut назад"
}