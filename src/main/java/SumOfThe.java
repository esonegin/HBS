import java.util.Arrays;

public class SumOfThe {

    public static int SumOfThe(int N, int[] data) {

        int result;
        if (data.length > 2 || (data.length == 2 && data[0] != 0 && data[1] != 0)) {
            result = getIndexElEqualsSum(data);
        }
        else{
            result = getElFromTwoWithNull(data);
        }
            return result;
    }

    //SummTwoWithNull - getElFromTwoWithNull
    public static int getElFromTwoWithNull(int[] data) {
        int result = 0;
        if (data[0] != 0) {
            result = data[0];
        } else {
            result = data[1];
        }

        return result;
    }

    //SravnenieElementaSSummoy - getIndexElEqualsSum
    public static int getIndexElEqualsSum(int[] data) {
        int result = 0;
        //Проходим по массиву сравнивая каждый элемент с суммой оставшихся
        for (int i = 0; i < data.length; i++) {
            if (checkSumEqualsEl(i, data) == true) {
                result = data[i];
            }
        }
        return result;
    }

    //SumWithoutIndex - checkSumEqualsEl
    public static boolean checkSumEqualsEl(int elindex, int[] data) {
        //result - isEqualSumRemaining
        boolean isEqualSumRemaining = false;
        //Копируем входящий массив
        int[] dataCopy = Arrays.copyOf(data, data.length);
        //"Удаляем" индекс из копии входящего массива
        dataCopy[elindex] = 0;
        //Считаем сумму элементов массива
        //sum - sumRemaining
        int sumRemaining = 0;
        for (int i = 0; i < dataCopy.length; i++)
            sumRemaining += dataCopy[i];

        if (data[elindex] == sumRemaining) {
            isEqualSumRemaining = true;
        }
        return isEqualSumRemaining;
    }
}
