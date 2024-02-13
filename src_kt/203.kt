import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val parts = reader.readLine().split(" ")
    val nTowns = parts[0].toInt()
    val mRoads = parts[1].toInt()
    val greenRoad = HashMap<Int, HashSet<Int>>()
    val yellowRoad = HashMap<Int, HashSet<Int>>()
    val redRoad = HashMap<Int, HashSet<Int>>()

    val edgesAB = Array(nTowns) { IntArray(nTowns) }
    val edgesBC = Array(nTowns) { IntArray(nTowns) }
    val edgesCD = Array(nTowns) { IntArray(nTowns) }

    for (i in 0 until mRoads) {
        val road = reader.readLine().split(" ")
        val start = road[0].toInt() - 1
        val finish = road[1].toInt() - 1
        when (road[2]) {
            "g" -> {
                edgesAB[start][finish]++
                if (greenRoad[start].isNullOrEmpty()) {
                    greenRoad[start] = HashSet()
                    greenRoad[start]!!.add(finish)
                }
                else
                    greenRoad[start]!!.add(finish)
            }
            "y" -> {
                edgesBC[start][finish]++
                if (yellowRoad[start].isNullOrEmpty()) {
                    yellowRoad[start] = HashSet()
                    yellowRoad[start]!!.add(finish)
                }
                else
                    yellowRoad[start]!!.add(finish)
            }
            "r" -> {
                edgesCD[start][finish]++
                if (redRoad[start].isNullOrEmpty()) {
                    redRoad[start] = HashSet()
                    redRoad[start]!!.add(finish)
                }
                else
                    redRoad[start]!!.add(finish)
            }
        }
    }
    val nQuest = reader.readLine().toInt()

    val roadAC = Array(nTowns ) { IntArray(nTowns) }
    val roadAD = Array(nTowns ) { IntArray(nTowns) }
    for (a in 0 until nTowns) {
        for (b in 0 until nTowns)
            for (c in yellowRoad[b].orEmpty())
                roadAC[a][c] += edgesAB[a][b] * edgesBC[b][c]

        for (c in 0 until nTowns)
            for (d in redRoad[c].orEmpty())
                roadAD[a][d] += roadAC[a][c] * edgesCD[c][d]

    }

    for (que in 0 until nQuest) {
        val question = reader.readLine().split(" ")
        val start = question[0].toInt() - 1
        val finish = question[1].toInt() - 1
        val countRoads = roadAD[start][finish]


        writer.write(countRoads.toString())
        writer.newLine()
    }

    reader.close()
    writer.close()
}
