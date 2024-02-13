import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    var maxPoz = Long.MIN_VALUE
    var minPoz = Long.MAX_VALUE
    var maxNeg = Long.MIN_VALUE
    var minNeg = Long.MAX_VALUE
    var countZero = 0
    var countPoz = 0
    var countNeg = 0

    val string = reader.readLine().split(" ")
    for (i in 0 until n) {
        val temp = string[i].toLong()
        if (temp == 0L) {
            countZero++
            continue
        }
        if (temp > 0L) {
            countPoz++
            if (temp > maxPoz)
                maxPoz = temp
            if (temp < minPoz)
                minPoz = temp
            continue
        }
        countNeg++
        if (temp > maxNeg)
            maxNeg = temp
        if (temp < minNeg)
            minNeg = temp
    }

    var res : Long
    if (countZero > 1)
        res = 0
    if (countZero == 1) {
        if (countNeg % 2 == 1)
            res = minNeg
        else
            res = 0
    }
    else {
        if (countNeg % 2 == 1)
            res = maxNeg
        else
            if (countPoz == 0)
                res = minNeg
            else
                res = minPoz
    }

    writer.write(res.toString())

    reader.close()
    writer.close()
}
