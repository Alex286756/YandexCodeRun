import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val parts = reader.readLine().split(":")
    val h1 = parts[0].toInt()
    val m1 = parts[1].toInt()
    val parts2 = reader.readLine().split(":")
    val h2 = parts2[0].toInt()
    val m2 = parts2[1].toInt()
    val n = reader.readLine().toInt();

    val mStart = (h1 + n)  * 60 + m1
    val mFinish = h2 * 60 + m2

    val res = when {
        mStart <= mFinish -> (mFinish - mStart) % 1440
        else -> (14400 - mStart + mFinish) % 1440
    }

    val resH = res / 60
    val resM = res % 60

    writer.write(String.format("%d:%02d", resH, resM))

    reader.close()
    writer.close()
}
