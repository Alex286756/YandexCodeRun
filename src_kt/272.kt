import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val ch = HashMap<Char, Int>()
    for (i in 0 until n) {
        val string = reader.readLine()
        val first = string[0]
        val temp = ch[first]
        if (temp != null) {
           ch[first] = temp + 1
        } else {
            ch[first] = 1
        }
    }

    val max = ch.maxBy { it.value }
    writer.write(max.key.toString())

    reader.close()
    writer.close()
}
