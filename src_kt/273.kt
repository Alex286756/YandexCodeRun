import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val parts = reader.readLine().split(" ")
    val s = parts[0].toInt()
    val n = parts[1].toInt()
    val address = IntArray(n)
    val parts2 = reader.readLine().split(" ")
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (i in parts2.indices) {
        address[i] = parts2[i].toInt()
        if (address[i] < min)
            min = address[i]
        if (address[i] > max)
            max = address[i]
    }

    var res = 0

    if (s < min)
        res = max - s
    else if (s > max)
        res = s - min
    else if (s - min > max - s)
        res = max - s + max - min
    else
        res = s - min + max - min

    writer.write(res.toString())

    reader.close()
    writer.close()
}
