import java.util.Arrays;

public class SumOfThe {

    private static int[] listofnumbers;

    //Выясняем есть ли в массиве число равное сумме остальных чисел
    //Вынес инициализацию списка в конструктор
    public SumOfThe(int[] data) {
        this.listofnumbers = data;
    }

    public static int getSum() {
        int result;
        if (listofnumbers.length > 2 || (listofnumbers.length == 2 && listofnumbers[0] != 0 && listofnumbers[1] != 0)) {
            result = getIndexElEqualsSum(listofnumbers);
        } else {
            result = getElFromTwoWithNull(listofnumbers);
        }
        return result;
    }

    //SummTwoWithNull - getElFromTwoWithNull
    public static int getElFromTwoWithNull(int[] data) {
        if (data[0] != 0) {
            return data[0];
        }
        return data[1];
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
        for (int j : dataCopy) {
            sumRemaining += j;
        }
        if (data[elindex] == sumRemaining) {
            isEqualSumRemaining = true;
        }
        return isEqualSumRemaining;
    }
}
