package subtask2

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        val decomposeArray = decomposer(number.toLong(), number * number.toLong()) ?: return null
        decomposeArray.removeAt(decomposeArray.size - 1)

        return decomposeArray.toTypedArray()
    }

    private fun decomposer(number: Long, remain: Long): ArrayList<Int>?{
        if(remain == 0L){
            val list = ArrayList<Int>()
            list.add(number.toInt())
            return list
        }

        for(i in number - 1 downTo 1){
            val currentDecNumber = remain - i * i
            if(currentDecNumber >= 0){
                val list = decomposer(i, currentDecNumber)

                if(list != null){
                    list.add(number.toInt());
                    return list
                }
            }
        }

        return null;
    }
}
