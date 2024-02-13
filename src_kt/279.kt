import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class RoomCount(public var ki: Int, public var kol: Int): Comparable<RoomCount> {

    override fun compareTo(other: RoomCount): Int {
        if (this.ki > other.ki)
            return 1
        return 0
    }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val parts = reader.readLine().split(" ")
    var commands = IntArray(n)
    for (i in parts.indices) {
        commands[i] = parts[i].toInt()
    }
    val k = reader.readLine().toInt()
    var rooms = Array(k) { RoomCount(0, 0)}
    var summaryRooms = 0
    for (i in 0 until k) {
        val parts2 = reader.readLine().split(" ")
        val ki = parts2[0].toInt()
        val kol = parts2[1].toInt()
        summaryRooms += kol
        rooms[i].ki = ki
        rooms[i].kol = kol
    }

    if (summaryRooms < n) {
        writer.write("No")

        reader.close()
        writer.close()
        return
    }

    rooms = rooms.sortedBy { it.ki }.toTypedArray()
    commands = commands.sorted().toIntArray()

    var roomsIndex = rooms.size - 1
    var commandIndex = commands.size - 1
    var result = true

    while (result && roomsIndex >= 0 && commandIndex >= 0) {
        if (rooms[roomsIndex].ki >= commands[commandIndex]) {
            if (rooms[roomsIndex].kol > 1)
                rooms[roomsIndex].kol--
            else
                roomsIndex--
            commandIndex--
        } else {
            result = false
        }
    }

    if (result) {
        writer.write("Yes")
    } else {
        writer.write("No")
    }

    reader.close()
    writer.close()
}
