package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val wordList = MutableList(0, { "" }) // список слов (String)
        val keysSearchWord = hashMapOf('[' to ']', '(' to ')', '<' to '>') // искомые ключи, промежутки
        var indexListWords = 0 // для добавления и прохода по словам

        var indexStartWord = -1 // индекс начала, для найденного слова
        var indexEndWord = -1 // индекс конца, для найденного слова
        var symbolStartWord = ' ' // первый символ для найденного слова

        var indexInput = 0 // индефикатор для перебора по символам
        var cntStart = 0 // кол-во записей найдено с подобным Началом
        var cntEnd = 0 //  кол-во записей найдено с подобным Концом

        while (indexInput in inputString.indices) {  // начала цикла для перебора по символам входного слова
            val elementToInput = inputString[indexInput]  // получение символа
            if (elementToInput == '[' || elementToInput == '(' || elementToInput == '<') {// вначале найденное слово неважно, для него будет проверка всеравно
                if (indexStartWord == -1 && indexEndWord == -1) { // для начального этапа слова
                    indexStartWord = indexInput // получаем начальный индекс данного слова
                    symbolStartWord = elementToInput // получаем первый найденный символ

                }
                if (elementToInput == symbolStartWord)
                    cntStart++
            }

            if (elementToInput == keysSearchWord[symbolStartWord] && indexStartWord != -1) { // для данного слова находим завершающий ключ
                if (indexEndWord == -1) { // заносим конец
                    indexEndWord = indexInput
                    cntEnd++
                }
                if (indexEndWord != -1 && cntStart == 1 && cntEnd == 1 && indexInput > indexEndWord) { // для конечного этапа слова
                        indexEndWord = indexInput
                }
                if (indexEndWord != -1 && cntStart == 2 && cntEnd == 1) {
                    cntStart = 1
                    cntEnd = 1
                }
            }

            // Добавление записи
            if (indexInput == inputString.length - 1 && indexEndWord != -1 && indexEndWord < inputString.length) {
                wordList.add(inputString.substring(indexStartWord + 1, indexEndWord)) // вырезаем найденную строчку
                indexListWords++ // переход для списка

                // Новый запуск поиска и обнуление поумолчанию
                indexInput = indexStartWord
                symbolStartWord = ' '
                indexStartWord = -1
                indexEndWord = -1
                cntStart = 0

            }

            indexInput++ // прохождение по символам входного
        } // конец цикла для перебора по символам входного слова

        return wordList.toList<String>().toTypedArray()
    }
}
