public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
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
