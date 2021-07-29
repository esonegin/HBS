public class SelectionSort {
    //Переменная для отсечения отсортированных элементов
    static int k = 0;

    public static int[] selectionSort(int[] array) {
        for (int i = k; i < array.length; i++) {
            changeAndOtsechenie(array, linerIndexMinSearch(array, k));
        }
        //Обнуляем переменную для отсечения
        k = 0;
        return array;
    }

    //Ищем линейно индекс минимального значения
    public static int linerIndexMinSearch(int[] array, int k) {
        int result = array.length - 1;
        for (int i = array.length - 1; i > k; i--) {
            if (array[i - 1] < array[result]) {
                result = i - 1;
            }
        }
        return result;
    }

    //Меняем найденый элемент с крайним левым и отсекаем его (если уже левое то только отсекаем)
    public static int[] changeAndOtsechenie(int[] array, int indexmin) {
        int change = array[k];
        array[k] = array[indexmin];
        array[indexmin] = change;
        k++;
        return array;
    }
}
