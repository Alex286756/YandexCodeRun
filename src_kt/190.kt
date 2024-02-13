import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Department(public var moneys: Long,
                 public var parent: Department?,
                 public var childs: HashSet<Department>,
                 public var rating: Long)

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val parts = reader.readLine().split(" ")
    val nDepartments = parts[0].toInt()
    val nMoneys = parts[1].toLong()
    val ratingsStr = reader.readLine().split(" ").map { it.toLong() }
    val parentsStr = reader.readLine().split(" ")
    val departments = Array(nDepartments + 1) { Department(0, null, HashSet(), 0) }
    for (i in parentsStr.indices) {
        val tempIndex = parentsStr[i].toInt()
        departments[i + 1].parent = departments[tempIndex]
        departments[i + 1].rating = ratingsStr[i]
        departments[tempIndex].childs.add(departments[i + 1])
    }
    departments[0].moneys = nMoneys

    divideMoneys(departments[0])

    for (i in 1 until nDepartments + 1)
        writer.write(departments[i].moneys.toString() + " ")

    reader.close()
    writer.close()
}

fun divideMoneys(startDepartment: Department) {
    if (startDepartment.childs.isNotEmpty()) {
        var sum = 0L
        var nodChilds = -1L

        startDepartment.childs.forEach {
            sum += it.rating
            if (nodChilds != 1L)
                if (nodChilds == -1L)
                    nodChilds = it.rating
                else
                    nodChilds = nod(nodChilds, it.rating)
        }

        val sum1 = sum / nodChilds
        val money = startDepartment.moneys / sum1
        startDepartment.childs.forEach {
            it.moneys = money * it.rating / nodChilds
            divideMoneys(it)
        }
    }
}

fun nod(a : Long, b : Long) : Long {
    var n1 = a
    var n2 = b
    if (n1 == 0L) {
        return n2
    }

    if (n2 == 0L) {
        return n1
    }

    var n = 0
    while (n1 or n2 and 1L == 0L) {
        n1 = n1 shr 1
        n2 = n2 shr 1
        n++
    }

    while (n1 and 1L == 0L) {
        n1 = n1 shr 1
    }

    do {
        while (n2 and 1L == 0L) {
            n2 = n2 shr 1
        }
        if (n1 > n2) {
            val temp = n1
            n1 = n2
            n2 = temp
        }
        n2 -= n1
    } while (n2 != 0L)
    return n1 shl n
}
