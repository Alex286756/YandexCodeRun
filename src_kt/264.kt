import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val display = Array(1280) { IntArray(1920) }
    for (i in 1 until n + 1) {
        val coords = reader.readLine().split(" ")
        for (x in coords[0].toInt() until coords[2].toInt() + 1)
            for (y in coords[1].toInt() until coords[3].toInt() + 1)
                display[x][y] = i
    }

    val colors = HashSet<Int>()
    for (x in 0 until 1280)
        for (y in 0 until 1920)
            if (display[x][y] != 0)
                colors.add(display[x][y])

    writer.write(colors.size.toString())

    reader.close()
    writer.close()
}
