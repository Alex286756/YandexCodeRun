import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val t = reader.readLine().toInt()
    val nodes = HashSet<String>()
    val lines = HashMap<String, Int>()

    for (i in 0 until t) {
        var last = ""
        val parts = reader.readLine()
        for (j in 0 until parts.length - 2) {
            val temp = parts.substring(j, j + 3)
            nodes.add(temp)
            if (last != "") {
                val str = last + " " + temp
                lines[str] = addOne(lines[str])
            }
            last = temp
        }
    }

    writer.write(nodes.size.toString())
    writer.newLine()
    writer.write(lines.size.toString())
    writer.newLine()
    for (el in lines) {
        writer.write(el.key + " " + el.value.toString())
        writer.newLine()
    }

    reader.close()
    writer.close()
}


fun addOne(old: Int?): Int {
    if (old == null)
        return 1
    return  old.toInt() + 1
}
