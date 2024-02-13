import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    var index = 0
    val clasters = Array(n) { HashSet<Int>() }
    for (i in 0 until n) {
        val parts = reader.readLine().split(" ")
        val ware1 = parts[0].toInt()
        val ware2 = parts[1].toInt()
        index = fillClasters(clasters, ware1, ware2, index)
    }

    val t = reader.readLine().toInt()
    for (i in 0 until t) {
        val start = reader.readLine().split(" ")
        val startElemIndex = start[0].toInt()
        start[1].toInt()
        val finish = reader.readLine().split(" ")
        val searchElems = finish.toList().map { it.toInt() }
        for (list in clasters) {
            if (list.contains(startElemIndex)){
                val resList = searchElems.intersect(list)
                writer.write(resList.size.toString())
                if (resList.isNotEmpty()) {
                    for (el in resList) {
                        writer.write(" $el")
                    }
                }
                writer.newLine()
                break
            }
        }
    }

    reader.close()
    writer.close()
}

private fun fillClasters(
    clasters: Array<HashSet<Int>>,
    ware1: Int,
    ware2: Int,
    index: Int
): Int {
    var listElem1 = HashSet<Int>()
    var listElem2 = HashSet<Int>()
    var indexNew = index
    var tempIndex = 0
    for (j in 0 until index) {
        val list = clasters[j]
        if (list.contains(ware1)) {
            listElem1 = list
        }
        if (list.contains(ware2)) {
            listElem2 = list
            tempIndex = j
        }
        if (listElem1.isNotEmpty() && listElem2.isNotEmpty())
            break
    }
    if (listElem1.isEmpty())
        if (listElem2.isEmpty()) {
            indexNew++
            clasters[index].add(ware1)
            clasters[index].add(ware2)
        } else {
            listElem2.add(ware1)
        }
    else
        if (listElem2.isEmpty()) {
            listElem1.add(ware2)
        } else
            if (listElem1 != listElem2) {
                listElem1.addAll(listElem2)
                clasters[tempIndex] = clasters[index]
                clasters[index].clear()
                indexNew--
            }
    return indexNew
}
