import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine()

    var parts = HashMap<Int, String>()
    parts = countPartsWithStart(parts, n, 0)

    for ((key, value) in parts)
        if (key == 0)
            writer.write(value)
        else
            writer.write("-$value")

    reader.close()
    writer.close()
}

private fun countPartsWithStart(
    parts: HashMap<Int, String>,
    strIn: String,
    index: Int
): HashMap<Int, String> {
    val tempParts = HashMap(parts)
    if (strIn.length == 1) {
        if (tempParts.containsValue(strIn)) {
            return HashMap()
        }
        else {
            tempParts[index] = strIn
            return tempParts
        }
    }
    if (strIn[0] == '0') {
        if (tempParts.containsValue("0")) {
            return HashMap()
        }
        tempParts[index] = "0"
        return countPartsWithStart(tempParts, strIn.substring(1), index + 1)
    }

    val newChar = strIn[0].toString()
    if (tempParts.containsValue(newChar)) {
        tempParts[index] = newChar
        return countPartsContinue(tempParts, strIn.substring(1), index)
    }
    tempParts[index] = newChar
    val newParts = countPartsWithStart(tempParts, strIn.substring(1), index + 1)
    val yes = newParts.size
    val oldParts = countPartsContinue(tempParts, strIn.substring(1), index)
    val no = oldParts.size
    if (yes > no)
        return newParts
    else
        return oldParts
}

private fun countPartsContinue(
    parts: HashMap<Int, String>,
    strIn: String,
    index: Int
): HashMap<Int, String> {
    val tempParts = HashMap(parts)
    if (strIn.length == 1) {
        val tempValue = "${tempParts[index]}$strIn"
        if (tempParts.containsValue(tempValue)) {
            return HashMap()
        }
        else {
            tempParts[index] = tempValue
            return tempParts
        }
    }

    val newPart = "${tempParts[index]}${strIn[0]}"
    if (tempParts.containsValue(newPart)) {
        tempParts[index] = newPart
        return countPartsContinue(tempParts, strIn.substring(1), index)
    }
    tempParts[index] = newPart
    val newParts = countPartsWithStart(tempParts, strIn.substring(1), index + 1)
    val yes = newParts.size
    val oldParts = countPartsContinue(tempParts, strIn.substring(1), index)
    val no = oldParts.size
    if (yes > no)
        return newParts
    else
        return oldParts
}
