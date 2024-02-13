import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val partsA = reader.readLine().split(" ")
    val n = partsA[0].toInt()
    val m = partsA[1].toInt()
    val k = partsA[2].toInt()

    var pole = Array(n) {IntArray(m)}
    val change = Array(n) {IntArray(m)}
    for (i in 0 until n) {
        val partsB = reader.readLine().split(" ")
        for (j in 0 until m) {
            pole[i][j] = partsB[j].toInt()
        }
    }

    for (i in 0 until k) {
        pole = step(pole, n, m, change)
    }

    for (i in 0 until n) {
        var str = ""
        for (j in 0 until m) {
           str += change[i][j].toString() + " "
        }
        writer.write(str)
        writer.newLine()
    }

    reader.close()
    writer.close()
}

fun step(pole: Array<IntArray>, n: Int, m: Int, change: Array<IntArray>): Array<IntArray> {
    val temp = Array(n) {IntArray(m)}

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (countStable(pole, i, j, n, m) > 1) {
                temp[i][j] = 2
            } else if (countActive(pole, i, j, n, m) > 0) {
                temp[i][j] = 3
            } else {
                temp[i][j] = 1
            }
            if (pole[i][j] != temp[i][j]) {
                change[i][j]++
            }
        }
    }

    return temp
}

fun countActive(pole: Array<IntArray>, i: Int, j: Int, n: Int, m: Int): Int {
    var temp = 0

    temp += when {
        i == 0 -> 0
        pole[i-1][j] >= 2 -> 1
        else -> 0
    }
    temp += when {
        i == n-1 -> 0
        pole[i+1][j] >= 2 -> 1
        else -> 0
    }

    temp += when {
        j == 0 -> 0
        pole[i][j-1] >= 2 -> 1
        else -> 0
    }

    temp += when {
        j == m-1 -> 0
        pole[i][j+1] >= 2 -> 1
        else -> 0
    }

    return temp
}

fun countStable(pole: Array<IntArray>, i: Int, j: Int, n: Int, m: Int): Int {
    var temp = 0

    temp += when {
        i == 0 -> 0
        pole[i-1][j] == 2 -> 1
        else -> 0
    }
    temp += when {
        i == n-1 -> 0
        pole[i+1][j] == 2 -> 1
        else -> 0
    }

    temp += when {
        j == 0 -> 0
        pole[i][j-1] == 2 -> 1
        else -> 0
    }

    temp += when {
        j == m-1 -> 0
        pole[i][j+1] == 2 -> 1
        else -> 0
    }

    return temp
}
