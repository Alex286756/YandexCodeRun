import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val d = HashMap<Int, Int>()
    val a = IntArray(n + 1)

    val bosses = reader.readLine().split(" ")

    for (i in 0 until n ) {
        val a1 = i + 1
        val a2 = bosses[i].toInt()
        d[a1] = a2
    }


    for ((key, value ) in d) {
        var  s = value
        while (d.containsKey(s)) {
            if (a[s] != 0) {
                a[key] += a[s] + 1
                break
            }
            s = d[s]!!
            a[key]++
        }
    }

    for (i in 1 until n + 1)
        writer.write(a[i].toString() + " ")

    reader.close()
    writer.close()
}

