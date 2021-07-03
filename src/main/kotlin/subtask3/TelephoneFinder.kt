package subtask3

class TelephoneFinder {

    private val phoneNumbers = arrayOf(
        arrayOf("1", "2", "3"),
        arrayOf("4", "5", "6"),
        arrayOf("7", "8", "9"),
        arrayOf("*", "0", "#")
    )

    private val neighborsNumbers = ArrayList<String>()

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        if (number.first().isDigit()) {
            for (char in number) {
                val (row, column) = findPosition(char.toString())
                if (row != null && column != null) {
                    findNeighbors(number, row, column)
                }
            }

            return neighborsNumbers.toTypedArray()
        }

        return null
    }

    private fun findPosition(number: String): Pair<Int?, Int?> {
        for (i in phoneNumbers.indices) {
            if (phoneNumbers[i].contains(number)) {
                return Pair(i, phoneNumbers[i].indexOf(number))
            }
        }

        return Pair(null, null)
    }

    private fun findNeighbors(number: String, row: Int, column: Int) {
        val rows: Int = phoneNumbers.size
        val columns: Int = phoneNumbers[0].size

        for (i in row - 1..row + 1) {
            for (j in column - 1..column + 1) {
                if ((i == row + 1 || i == row - 1) && (j == column - 1 || j == column + 1)) {
                    continue
                }
                if (j >= 0 && i >= 0 && j < columns && i < rows && !(i == row && j == column)) {
                    //println("neighbors: " + phoneNumbers[i][j])

                    when(phoneNumbers[row][column]) {
                        "0" -> {
                            neighborsNumbers.add(number.replace(phoneNumbers[row][column], "8"))
                            return
                        }
                        else -> {
                            if (phoneNumbers[i][j] == "*" || phoneNumbers[i][j] == "#") return
                            neighborsNumbers.add(number.replace(phoneNumbers[row][column], phoneNumbers[i][j]))
                        }
                    }
                }
            }
        }
    }
}
