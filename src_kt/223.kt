import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val parts = reader.readLine().split(" ")
    val numbers = IntArray(n)
    val home = IntArray(n)
    var oddNumbers = 0
    var evenNumbers = 0
    var homePlaced = 0
    for (i in 0 until n) {
        numbers[i] = parts[i].toInt()

        if (numbers[i] % 2 == 0) {
            evenNumbers++  // четный
            if (i%2 == 1) {
                homePlaced++
                home[i] = 1
            } else
                home[i] = 0
        }
        else {
            oddNumbers++
            if (i%2 == 0) {
                homePlaced++
                home[i] = 1
            } else
                home[i] = 0
        }
    }

    when (evenNumbers - oddNumbers) {
        -1 -> oddBigger(writer, numbers)          // нечетных больше на 1
        0 -> equals(writer, home, numbers, homePlaced)
        1 -> evenBigger(writer, numbers)          // четных больше на 1
        else -> noResults(writer)
    }

    reader.close()
    writer.close()
}

fun evenBigger(writer: BufferedWriter, numbers: IntArray) {
    val  changes = toChange(numbers,  0)

    writer.write(changes.toString())
    writer.newLine()
    for (element in numbers)
        writer.write("$element ")
}

fun oddBigger(writer: BufferedWriter, numbers: IntArray) {
    val  changes = toChange(numbers,  1)

    writer.write(changes.toString())
    writer.newLine()
    for (element in numbers)
        writer.write("$element ")
}

fun noResults(writer: BufferedWriter) {
    writer.write("-1")
}

fun equals(writer: BufferedWriter, home: IntArray, numbers: IntArray, homePlaced: Int) {
    val numbers1 = numbers.clone()
    val numbers2 = numbers.clone()
    val changes1 = toChange(numbers1,  0)
    val changes2 = toChange(numbers2, 1)

    if (changes1 < changes2) {
        writer.write(changes1.toString())
        writer.newLine()
        for (element in numbers1)
            writer.write("$element ")
    }
    else {
        writer.write(changes2.toString())
        writer.newLine()
        for (element in numbers2)
            writer.write("$element ")
    }
}

fun toChange(
    numbers: IntArray,
    whoFirst: Int           // 1 - нечет на 1 месте, 0 - чет
) : Int {
    var changes = 0
    val places = Stack(numbers.size)
    for (i in numbers.indices) {
        if (whoFirst == 1) {
            if (i%2 == numbers[i]%2)
                if (places.isEmpty())
                    places.push(i)
                else {
                    val temp = numbers[i]
                    if (temp%2 == places.peek()%2)
                        places.push(i)
                    else {
                        numbers[i] = numbers[places.peek()]
                        numbers[places.pop()] = temp
                        changes += 2
                    }

                }
        }
        else {
            if (i%2 != numbers[i]%2)
                if (places.isEmpty())
                    places.push(i)
                else {
                    val temp = numbers[i]
                    val tempOld = numbers[places.peek()]
                    if (temp%2 == tempOld%2)
                        places.push(i)
                    else {
                        numbers[i] = numbers[places.peek()]
                        numbers[places.pop()] = temp
                        changes += 2
                    }

                }
        }
    }
    return changes
}

class Stack(val size: Int) {
    private val stackArray = IntArray(size)
    private var top = -1

    fun push(number: Int) {
        stackArray[++top] = number
    }

    fun pop(): Int {
        return stackArray[top--]
    }

    fun peek(): Int {
        return stackArray[top]
    }

    fun isEmpty(): Boolean {
        return top == -1
    }
}
