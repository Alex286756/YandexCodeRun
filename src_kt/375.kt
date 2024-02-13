import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val k = reader.readLine().toInt()
    val n = reader.readLine().toInt()

    val jokes = IntArray(n + 1)
    var startTime = 0
    val jokesParts = reader.readLine().split(" ")
    for (i in 1 until n + 1) {
        jokes[i] = jokesParts[i - 1].toInt()
        startTime += i * jokes[i]
    }
    val startSum = jokes.sum()
    var max = startSum + k
    var curDif = max

    for (i in 1 until n + 1) {
        val dif =  k - jokes[i]
        curDif += dif
        if (curDif > max)
            max = curDif
    }

    writer.write(max.toString())

    reader.close()
    writer.close()
}
