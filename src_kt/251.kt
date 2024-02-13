import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val strIn = reader.readLine()
    val setC = reader.readLine()

    writer.write(work(strIn, setC))

    reader.close()
    writer.close()
}

fun work(strIn: String, setIn: String): String {
    val set2 = setIn.toHashSet()
    var min = Int.MAX_VALUE
    for (left in strIn.indices) {
        for (right in left until strIn.length) {
            val tempStr = strIn.substring(left, right + 1)
            val tempSet = tempStr.toHashSet()
            if (tempSet == set2) {
                val len = tempStr.length
                if (len < min)
                    min = len
            }
            if (min == set2.size)
                break
        }
        if (min == set2.size)
            break
    }

    if (min == Int.MAX_VALUE)
        return "0"
    return min.toString()
}
