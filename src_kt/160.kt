import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val parts = reader.readLine().split(" ")
    val n = parts[0].toInt()
    val m = parts[1].toInt()

    val towns = BooleanArray(n){true}
    val roads = Array(n) {HashSet<Int>()}

    for (i in 0 until m) {
        val road = reader.readLine().split(" ")
        val townFrom = road[0].toInt() - 1
        val townTo = road[1].toInt() - 1
        if (townFrom != townTo) {
            towns[townFrom] = false
            if (towns[townTo]) {
                roads[townTo].add(townFrom)
            }
        }
    }

    var res = -1
    for (i in 0 until n) {
        if (towns[i] && roads[i].size == n - 1) {
            res = i + 1
            break
        }
    }

    writer.write(res.toString())

    reader.close()
    writer.close()
}
