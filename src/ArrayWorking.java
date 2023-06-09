
public class ArrayWorking {
    private int[] arr = new int[10];              // Выделяем память под массив
    private int count = 0;                        // Счетчик добавленных элементов

    /**
     * Метод для поиска элемента
     * @param value искомое значение
     * @return индекс элемента
     */
    public int find(int value){
        for(int i = 0; i < count; i++){         // Проходим массив в цикле(итерируем)
             if(value == arr[i]){               // Проверяем совпадает ли элемент массива с искомым значением
                 return i;                      // Если совпадает, возвращаем индекс элемента
             }
        }
        System.out.println("Элемента нет");    // Если нет, выводим сообщение и возвращаем индекс равный -1
        return -1;
    }

    /**
     * Метод для вставки значения в массив
     * @param value само значение
     */
    public void insert(int value){
        if(count >= 0.8*arr.length){      // Делали с продленкой выделение памяти
            int[] temp = arr;
            arr = new int[2*arr.length];
            copy(temp);
        }
        arr[count] = value;              // Вставляем элемент в свободную ячейку массива
        count++;                         // Увеличиваем счетчик элементов в массиве
    }

    private void copy(int[] temp) {
        for (int i = 0; i < count; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * Метод для удаления элемента
     * @param pos индекс элемента, который удаляем
     */
    public void delete(int pos){
        if(pos >= count){                                           // Проверяем, если идекс удаляемого элемента за пределами массива,
            System.out.println("Нет элемента по этому индексу");    // прекращаем исполнение и выводи сообщение в консоль
            return;
        }
        for (int i = pos; i < count ; i++) {                       // Проходим массив циклом(итерируем) от индекса удаления
             arr[i] = arr[i+1];                                    // Присваиваем каждому элементу значение соседнего
        }
        count--;                                                   // Сокращаем счетчик на 1(декрементируем)
    }

    /**
     * Метод для сортировки массива пузырьком
     */
    public void sort(){
        int temp = 0;                                             // Временная переменная для хранения переставляемого значения
        for (int i = 0; i < count; i++) {                         // Первый цикл для перебора массива
            for (int j = 0; j < count; j++) {                     // Второй цикл для перебора массива и сравнения каждого элемента с элементом из первого цикла
                 if(arr[i] > arr[j]) {                            // Сравниваем элемент из первого цикла с элементои из второго
                     temp = arr[i];                               // Если он больше, далем перестановку - во временную переменную помещаем элемент из первого цикла
                     arr[i] = arr[j];                             // В элемент из первого цикла записываем элемент из второго цикла
                     arr[j] = temp;                               // В элемент из второго записываем временную переменную, т.е. элемент из первого цикла
                 }
            }
        }
    }

    /**
     * Метод для перевода значений в строку
     * @return строчное предтсавление массива
     */
    @Override
    public String toString() {
        String str = " ";                     // Создаем строку
        for (int i = 0; i < count; i++) {     // Создаем цикл для пербора уже вставленных элементов
            str +=  arr[i] + " ";             // Прибавляем уже вставленный элемент к строке
        }
        return str;
    }

    // Методы для продленки
    public void clear(){
        count = 0;
    }

    public void hack(){
        count = arr.length;
    }

    public void erase(){
        for (int i = 0; i < count; i++) {
             arr[i] = 0;
        }
        count = 0;
    }
}
