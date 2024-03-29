public class SelectionSort {
    //Переменная для отсечения отсортированных элементов
    static int k = 0;

    public static int[] selectionSort(int[] array) {
        for (int i = k; i < array.length; i++) {
            rotateAndCutLeftEl(array, getMinIndex(array, k));
        }
        //Обнуляем переменную для отсечения
        k = 0;
        return array;
    }

    //Ищем линейно индекс минимального значения
    //linerIndexMinSearch - getMinIndex
    public static int getMinIndex(int[] array, int k) {
        int minimumValue = array.length - 1;
        for (int i = array.length - 1; i > k; i--) {
            if (array[i - 1] < array[minimumValue]) {
                minimumValue = i - 1;
            }
        }
        return minimumValue;
    }

    //Меняем найденый элемент с крайним левым и отсекаем его (если в крайней левой позиции то только отсекаем)
    //changeAndOtsechenie - rotateAndCutLeftEl
        public static int[] rotateAndCutLeftEl(int[] array, int indexmin) {
        int change = array[k];
        array[k] = array[indexmin];
        array[indexmin] = change;
        k++;
        return array;
    }
}
