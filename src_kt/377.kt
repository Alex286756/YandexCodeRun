import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val productsMap = HashMap<String, String>()
    val categories = HashMap<String, Int>()
    for (i in 0 until n){
        val parts = reader.readLine().split(" ")
        val cat = parts[1]
        productsMap[parts[0]] = cat
        categories[cat] = -1
    }
    var min = n
    val order = reader.readLine().split(" ")

    for (i in order.indices) {
        val key = productsMap[order[i]]!!
        if (categories[key] != -1) {
            val dif = i - categories[key]!!
            if (dif < min)
                min = dif
        }
        categories[key] = i
    }


    writer.write(min.toString())

    reader.close()
    writer.close()
}

