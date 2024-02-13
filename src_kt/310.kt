import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Character.isDigit
import java.util.*

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val s = reader.readLine().toCharArray()

    var len = -1
    var curNum = 0
    var q = false

    for (i in s.indices) {
        if (s[i].isDigit()) {
            curNum = curNum * 10 + s[i].toString().toInt()
            q = true
            continue
        }
        if (q) {
            len += curNum
            curNum = 0
            q = false
        } else {
            len++
        }
    }

    if (q) {
        len += curNum
    } else {
        len++
    }

    writer.write(len.toString())

    reader.close()
    writer.close()
}
