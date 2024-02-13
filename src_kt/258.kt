import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class AmountOfMoney(public var moneys: Int, public var weeks: Int): Comparable<AmountOfMoney> {

    override fun compareTo(other: AmountOfMoney): Int {
        if (this.moneys > other.moneys)
            return 1
        return 0
    }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val mainParts = reader.readLine().split(" ")
    val nBillBoards = mainParts[0].toInt()
    val kBisnessMen = mainParts[1].toInt()
    val wWeeks = mainParts[2].toInt()

    var counts = Array(kBisnessMen) { AmountOfMoney(0, 0) }

    for (i in 0 until kBisnessMen) {
        val parts = reader.readLine().split(" ")
        counts[i].moneys = parts[0].toInt()
        if (parts[1].toInt() > wWeeks)
            counts[i].weeks = wWeeks
        else
            counts[i].weeks = parts[1].toInt()
    }

    var sum = 0
    var ostatok = nBillBoards * wWeeks
    counts = counts.sortedBy { it.moneys }.toTypedArray()
    var c = kBisnessMen - 1
    while (c >= 0 && ostatok > 0) {
        if (counts[c].weeks > ostatok) {
            sum += counts[c].moneys * ostatok
            ostatok = 0
        }
        else {
            sum += counts[c].moneys * counts[c].weeks
            ostatok -= counts[c].weeks
        }
        c--
    }

    writer.write(sum.toString())

    reader.close()
    writer.close()
}
