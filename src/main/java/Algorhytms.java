import java.util.ArrayList;

public class Algorhytms {
    private static int[] arr;

    public Algorhytms(int[] a) {
        this.arr = a;
    }

    public static String fastSort() {
        ArrayList<Integer> menshe = new ArrayList<>();
        ArrayList<Integer> bolshe = new ArrayList<>();
        int oporniy = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < oporniy) {
                menshe.add(arr[i]);
            }
            if (arr[i] > oporniy) {
                bolshe.add(arr[i]);
            }
        }
        quicksort(menshe);
        quicksort(bolshe);

        return glue(menshe, bolshe, oporniy);
    }

    public static ArrayList<Integer> quicksort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        } else {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int pr = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, pr);
                }
            }
        }
        return list;
    }

    public static String glue(ArrayList<Integer> menshe, ArrayList<Integer> bolshe, int opornoe) {
        String result = "";
        for (int i = 0; i < menshe.size(); i++) {
            result = result + menshe.get(i) + " ";
        }
        result = result + opornoe + " ";
        for (int i = 0; i < bolshe.size(); i++) {
            result = result + bolshe.get(i) + " ";
        }
        return result.trim();
    }

}