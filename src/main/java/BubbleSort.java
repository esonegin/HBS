public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        //Если массив содержит один элемент - возвращаем массив
        if(array.length == 1){
            return array;
        }
        //Переменная для хранения промежуточного минимума
        int min;
        //Переменная для фиксации итераций
        int j = 0;
        //Переменная для отсекания индекса отсортированного числа
        int k = 0;

        for (int i = array.length - 1; k <= array.length; i--) {
            if(j == array.length - 1) {
                j = 0;
                k++;
                i = array.length - 1;
            }

            if (array[i] < array[i - 1]) {
                min = array[i];
                array[i] = array[i - 1];
                array[i - 1] = min;
            }
            j++;
        }
        return array;
    }
}
