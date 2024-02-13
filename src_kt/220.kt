import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val parts = reader.readLine().split(" ")
    val standard = IntArray(n)
    for (i in parts.indices)
        standard[i] = parts[i].toInt()
    standard.sort()

    val m = reader.readLine().toInt()
    for (i in 0 until m) {
        val b = reader.readLine().toInt()
        var left = 0
        var right = n - 1
        while (right - left > 1) {
            val newIndex = (right + left) / 2
            if (standard[newIndex] > b)
                right = newIndex
            else
                left = newIndex
        }
        if (standard[right] - b > b - standard[left]) {
            writer.write(standard[left].toString())
            writer.newLine()
        }
        else {
            writer.write(standard[right].toString())
            writer.newLine()
        }
    }

    reader.close()
    writer.close()
}
