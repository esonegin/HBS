
import java.util.ArrayList;
import java.util.Collections;


public class Football {

    static ArrayList<String> allfirstsort = new ArrayList<String>();

    //v2
    static boolean Football(int F[], int N) {
        allfirstsort.clear();
        boolean result = false;
        String standartsortvar = standartSort(F);
        String defaultstring = "";
        for (int i = 0; i < F.length; i++){
            defaultstring = defaultstring + F[i];
        }

        if (F.length == 0 || F.length == 1) {
            result = true;
        }
        else if (defaultstring.equals(standartsortvar)){
            result = false;
        }
        else{
            prmt(F, 0);
            result = sravnenieFirstVar(allfirstsort, standartsortvar);
        }

        return result;
    }

    public static Boolean sravnenieFirstVar(ArrayList<String> list, String standartsort) {
        Boolean result = false;
        String[] srav1;
        //Массив из символов стандартной сортировки ({1, 2, 3})
        String[] srav2 = standartsort.split("");
        int count = 0;
        //Проход по списку всех вариантов
        for (int i = 0; i < list.size(); i++) {
            srav1 = list.get(i).split("");
            for (int j = 0; j < srav1.length; j++) {
                if (!srav1[j].equals(srav2[j])) {
                    count++;
                }
            }
            if (count < 3) {
                result = true;
            }
        }
        return result;
    }

    private static void prmt(int[] pa, int i) {
        if (i == pa.length - 1) {
            strout(pa);
        } else {
            for (int j = i; j < pa.length; j++) {
                aswap(pa, i, j);
                prmt(pa, i + 1);
                aswap(pa, i, j);
            }
        }
    }

    private static void aswap(int[] pa, int i, int j) {
        int k = pa[i];
        pa[i] = pa[j];
        pa[j] = k;
    }

    private static void strout(int[] pa) {
        String s = "";
        for (int a : pa) {
            s += a + "";
        }
        allfirstsort.add(s);
    }

    public static String standartSort(int[] arr) {
        ArrayList<Integer> sort = new ArrayList<>();
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            sort.add(arr[i]);
        }
        Collections.sort(sort);
        for (int i = 0; i < sort.size(); i++) {
            result = result + sort.get(i);
        }
        return result;
    }

}
