import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val addresses = HashSet<String>()

    for (i in 0 until n) {
        val newAddress = reader.readLine().split("@")
        val login = getLogin(newAddress[0])
        val domain = getDomain(newAddress[1])
        addresses.add("$login@$domain")
    }

    writer.write(addresses.size.toString())

    reader.close()
    writer.close()
}

fun getDomain(str: String): String {
    return str.substringBeforeLast(".")
}

fun getLogin(str: String): String {
    return str.replace(".", "")
        .substringBefore("-")
}

