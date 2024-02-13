import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()

    val poleStart = Array(n) {IntArray(n)}
    val poleFinish = Array(n) {IntArray(n)}
    val numbers = IntArray(n * n + 1)
    for (i in 0 until n) {
        val parts = reader.readLine().split(" ")
        for (j in 0 until n) {
            poleStart[i][j] = parts[j].toInt()
            if (poleStart[i][j] != 0) {
                numbers[poleStart[i][j]] = 1
            }
        }
    }

    var count = nextCount(0, numbers)

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (poleStart[i][j] != 0) {
                poleFinish[i][j] = poleStart[i][j]
            } else {
                poleFinish[i][j] = count
                count = nextCount(count, numbers)
            }
        }
    }

    for (i in 0 until n) {
        var str = ""
        for (j in 0 until n) {
           str += poleFinish[i][j].toString() + " "
        }
        writer.write(str)
        writer.newLine()
    }

    reader.close()
    writer.close()
}

fun nextCount(count: Int, numbers: IntArray): Int {
    for (i in count + 1 until numbers.size){
        if (numbers[i] == 0) {
            return i
        }
    }

    return numbers.size
}
