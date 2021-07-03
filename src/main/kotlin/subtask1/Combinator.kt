package subtask1

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        for (count in 1..array.last()) {
            if (findNumberOfCombinations(array.last(), count) >= array.first()) {
                return count
            }
        }
        return null
    }

    private fun factorial(number: Int): Long {
        return if (number == 0 || number == 1) 1 else factorial(number - 1) * number
    }

    private fun findNumberOfCombinations(totalNumberOfColors: Int, numberOfColors: Int): Long {
        return factorial(totalNumberOfColors) / (factorial(numberOfColors) * factorial(totalNumberOfColors - numberOfColors))
    }
}
