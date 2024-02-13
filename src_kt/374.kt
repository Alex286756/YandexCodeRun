import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))


    val parts = reader.readLine().split(" ")
    val a = parts[0].toLong()
    val b = parts[1].toLong()
    val c = parts[2].toLong()

    if (a >= b)
        if (b >= c)
            writer.write(b.toString())
        else
            if (a >= c)
                writer.write(c.toString())
            else
                writer.write(a.toString())
    else
        if (b < c)
            writer.write(b.toString())
        else
            if (a >= c)
                writer.write(a.toString())
            else
                writer.write(c.toString())

    reader.close()
    writer.close()
}

