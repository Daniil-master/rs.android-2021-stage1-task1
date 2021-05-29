package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        var happyArray = MutableList<Int>(sadArray.size, { it }) // создаем изменяемый список
        sadArray.forEachIndexed { index, el ->
            happyArray[index] = el // получаем данные от полученного массива
        }

        var index = 0 // для прохода по списку
        while (index in 0..happyArray.size) {
            if (index > 0 && index < happyArray.size - 1) { // первый и конечный не учитываем
                if (happyArray[index - 1] + happyArray[index + 1] < happyArray[index]) { // проверем на плохой
                    happyArray.removeAt(index) // удаляем плохой элемент
                    index = 0 // обнуляем цикл
                }
            }
            index++
        }

        return happyArray.toIntArray()
    }
}
