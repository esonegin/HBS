import java.util.TreeSet;

public class UFO {

    public static TreeSet UFO(int N, int[] data, boolean octal) {
        //Заменил массив на TreeSet
        TreeSet result = new TreeSet();
        for (int i = 0; i < data.length; i++) {
            result.add(strPoNomeruIndexa(data, i, octal));
        }
        return result;
    }

    public static int strPoNomeruIndexa(int[] array, int index, boolean octal) {
        int dlinnaelementa = String.valueOf(array[index]).length();
        int[] result = new int[dlinnaelementa];
        for (int i = 0; i < dlinnaelementa; i++) {
            result[i] = (sixPoIndexu(array, index)[i]);
        }
        int[] secondres = finalint(result, octal);
        String thirdres = "";
        for (int i = 0; i < secondres.length; i++) {
            thirdres += String.valueOf(secondres[i]);
        }
        return Integer.parseInt(thirdres);
    }

    public static int[] sixPoIndexu(int array[], int index) {
        String number = String.valueOf(array[index]);
        String[] first = number.split("");
        int[] resultfirst = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            if (first.length - i > 0) {
                resultfirst[i] = Integer.parseInt(first[first.length - i - 1]);
            } else break;
        }
        return resultfirst;
    }

    public static int[] finalint(int[] array, boolean octal) {
        String[] resultstring;

        int resultintpred = 0;
        if (octal) {
            for (int i = 0; i < array.length; i++) {
                resultintpred += (int) (array[i] * Math.pow(8, i));
            }

        } else
            for (int i = 0; i < array.length; i++) {
                resultintpred += (int) (array[i] * Math.pow(16, i));
            }
        resultstring = String.valueOf(resultintpred).split("");
        int[] resultint = new int[resultstring.length];
        for (int i = 0; i < resultstring.length; i++) {
            resultint[i] = Integer.parseInt(resultstring[i]);
        }
        return resultint;
    }
}
