import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val s = reader.readLine().lowercase(Locale.getDefault()).toCharArray()

    var a = 0
    var b = s.size - 1
    var q = true

    while (a <= b) {
        if (s[a] == ' ') {
            a++
            continue
        }
        if (s[b] == ' ') {
            b--
            continue
        }
        if (s[a] == s[b]) {
            a++
            b--
        } else {
            q = false
            break
        }
    }

    if (q) {
        writer.write("It is a palindrome")
    } else {
        writer.write("It is not a palindrome")
    }

    reader.close()
    writer.close()
}
