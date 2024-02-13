import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val parts = reader.readLine().split(" ")
    val nDays = parts[0].toInt()
    val weekday = when (parts[1]) {
        "Monday" -> 0
        "Tuesday" -> 1
        "Wednesday" -> 2
        "Thursday" -> 3
        "Friday" -> 4
        "Saturday" -> 5
        else -> 6
    }

    var curDay = 1
    var curWeekDay = weekday
    while (curDay <= nDays) {
        var strOut = ""

        for (i in 0 until curWeekDay) {
            strOut = "$strOut.. "
        }
        while (curWeekDay < 7 && curDay <= nDays){
            strOut += getDate(curDay)
            curDay++
            curWeekDay++
        }

        writer.write(strOut)
        writer.newLine()
        curWeekDay = 0
    }

    reader.close()
    writer.close()
}

fun getDate(curDay: Int): String {
    if (curDay > 9)
        return "$curDay "
    return ".$curDay "
}
