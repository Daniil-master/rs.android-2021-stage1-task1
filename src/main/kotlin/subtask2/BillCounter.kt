package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val arr = MutableList(bill.size, { it }) // создаем изменяеммый список
        bill.forEachIndexed { index, el ->
            arr[index] = el // заполняем список
        }
        arr.removeAt(k) // удаляем по индексу

        var shouldAnna = 0 // долг Анны. получаем сумму:
        arr.forEach {  shouldAnna += it }
        shouldAnna /= 2 // расчитываем часть

        if (shouldAnna == b)
            return "Bon Appetit"
        else
            return "${b - shouldAnna}"
    }
}
