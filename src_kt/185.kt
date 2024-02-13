import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val a = IntArray(n)
    val partsA = reader.readLine().split(" ")
    for (i in 0 until n) {
        a[i] = partsA[i].toInt()
    }
    val b = IntArray(n)
    val partsB = reader.readLine().split(" ")
    for (i in 0 until n) {
        b[i] = partsB[i].toInt()
    }

    var index = 1
    var min = Int.MAX_VALUE
    for (i in 0 until n) {
        val c = count(a, b, i)
        if (c < min) {
            min = c
            index = i + 1
        }
    }

    writer.write("$index $min")
    reader.close()
    writer.close()
}

fun count(a: IntArray, b: IntArray, start: Int) : Int {
    var sum = 0
    for (i in a.indices) {
        val x = a[(i + start) % a.size]
        val y = b[i]
        sum += when {
            x > y -> 0
            x + 100 >= y -> (y - x) / 2
            else -> 30
        }
    }
    return sum
}
