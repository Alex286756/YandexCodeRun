import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val s = reader.readLine().toCharArray()

    val parts = reader.readLine().split(" ")
    var chMax = s[0]
    var timeMax = parts[0].toInt()


    for (i in 1 until n) {
        val curTime = parts[i].toInt() - parts[i - 1].toInt()
        if (curTime >= timeMax) {
            timeMax = curTime
            chMax = s[i]
        }

    }

    writer.write(chMax.toString())

    reader.close()
    writer.close()
}
