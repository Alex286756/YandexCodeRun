import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val parts = reader.readLine().split(" ")
    val h = parts[0].toInt()
    val n = parts[1].toInt()

    val lines = IntArray(n)
    val linesParts = reader.readLine().split(" ")
    for (i in 0 until n) {
        lines[i] = linesParts[i].toInt()
    }
    val sum = lines.sum()
    var w = 1 + sum / h
    var q = false
    while (!q) {
        w--
        q = canPlace(h, lines, n, sum, w)
    }

    writer.write(w.toString())

    reader.close()
    writer.close()
}

fun canPlace(h: Int, lines: IntArray, n: Int, sum: Int, w: Int): Boolean {
    var index = 0
    var lineNumber = 1
    var dlina = 0
    var ostatokSum = sum
    while (index < n) {
        dlina += lines[index]
        ostatokSum -= lines[index]
        if (dlina >= w) {
            if ((h - lineNumber) * w > ostatokSum)
                return false
            else {
                dlina = 0
                lineNumber++
            }
        }
        index++
    }
    return true
}
