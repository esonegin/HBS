public class BubbleSort {
    static int[] array;

    //Убрал объявление переменной в конструктор
    public BubbleSort(int[] arr) {
        this.array = arr;
    }


    public static int[] bubbleSort() {
        //7.3, 7.4 i, j - currentValueIndex, comparedValueIndex
        for (int currentValueIndex = 0; currentValueIndex < array.length; currentValueIndex++) {
            for (int comparedValueIndex = 0; comparedValueIndex < array.length; comparedValueIndex++) {
                if (array[currentValueIndex] < array[comparedValueIndex]) {
                    //7.4 k - bufferValue
                    int bufferValue = array[currentValueIndex];
                    array[currentValueIndex] = array[comparedValueIndex];
                    array[comparedValueIndex] = bufferValue;
                }
            }

        }
        return array;
    }
}