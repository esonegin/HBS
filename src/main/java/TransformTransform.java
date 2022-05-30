import java.util.ArrayList;
import java.util.Collections;

public class TransformTransform {
//v3

    static boolean TransformTransform(Integer[] a, int n) {
        boolean result = true;
        int sum = 0;
        ArrayList<Integer> first = transformation(a);
        Integer[] secondarr = new Integer[first.size()];
        for (int i = 0; i < first.size(); i++) {
            secondarr[i] = first.get(i);
        }
        ArrayList<Integer> secondlist = transformation(secondarr);
        for (int r = 0; r < secondlist.size(); r++) {
            sum = sum + secondlist.get(r);
        }
        if (sum % 2 != 0) {
            result = false;
        }
        return result;
    }

    public static ArrayList<Integer> transformation(Integer[] a) {
        ArrayList<Integer> b = new ArrayList<Integer>();
        int k;
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = 0; j <= a.length - i - 1; j++) {
                k = i + j;
                b.add(maxIzDiappazona(a, j, k));
            }
        }
        return b;
    }

    public static int maxIzDiappazona(Integer[] a, int j, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = j; i <= k; i++) {
            result.add(a[i]);
        }
        return Collections.max(result);
    }
}
