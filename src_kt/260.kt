import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class phoneNumber {
    public var indexOfNumber : Int
    public var countOfDigit : Int
    public var schem : String
    public var countryCode : String
    public var operatorCode : String
    public var personalNumber : String
    public var country : String
    public var operator : String

    constructor(
        indexOfNumber: Int, countOfDigit: Int, schem: String, countryCode: String,
        operatorCode: String, personalNumber: String, country: String, operator: String
    ) {
        this.indexOfNumber = indexOfNumber
        this.countOfDigit = countOfDigit
        this.schem = schem
        this.countryCode = countryCode
        this.operatorCode = operatorCode
        this.personalNumber = personalNumber
        this.country = country
        this.operator = operator
    }

    override fun toString(): String {
        return "+$countryCode ($operatorCode) $personalNumber - $country  $operator"
    }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val numbersBase = MutableList<String>(n){ "" }
    for (i in 0 until n) {
        val readStr = reader.readLine()
        var tempStr = ""
        for (i in readStr.indices)
            if (readStr[i].isDigit())
                tempStr += readStr[i]
        numbersBase[i] = tempStr
    }
    val formOfNumbers = HashSet<phoneNumber>()
    val m = reader.readLine().toInt()
    for (i in 0 until m) {
        val readSchema = reader.readLine()
        formOfNumbers.add(convertToPhoneSchema(readSchema))
    }

    for (number in numbersBase) {
        val tempSchema = formOfNumbers.filter { it.countOfDigit == number.length }
                                      .filter { number.startsWith(it.schem) }.first()
        writePhoneToSchema(tempSchema, number)
        writer.write(tempSchema.toString())
        writer.newLine()
    }

    reader.close()
    writer.close()
}

fun writePhoneToSchema(tempSchema: phoneNumber, number: String) {
    tempSchema.personalNumber = number.substring(tempSchema.indexOfNumber)
}

fun convertToPhoneSchema(strIn: String): phoneNumber {
    val parts = strIn.split(" ")
    var countDigits = 0
    var schem =""
    val countryCode = parts[0].substringAfterLast("+")
    countDigits += countryCode.length
    schem += countryCode
    val operatorCode = parts[1].substringAfter("(").substringBefore(")")
    countDigits += operatorCode.length
    val indexOfNumber = countDigits
    schem += operatorCode
    var personalNumber = ""
    for (i in parts[2].indices) {
        if (parts[2][i].isDigit())
            personalNumber += parts[2][i]
        countDigits++
    }
    schem += personalNumber
    val country = parts[4]
    val operator = parts[5]
    return phoneNumber(indexOfNumber, countDigits, schem, countryCode, operatorCode,
        personalNumber, country, operator)
}
