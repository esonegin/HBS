import java.util.ArrayList;
import java.util.Collections;

public class TransformTransform {
//v3

    static boolean TransformTransform(Integer[] A, int N) {
        boolean result = true;
        int sum = 0;
        ArrayList<Integer> first = transformation(A);
        Integer [] secondarr = new Integer[first.size()];
        for (int i = 0; i < first.size(); i++) {
            secondarr[i] = first.get(i);
        }
        ArrayList<Integer> secondlist = transformation(secondarr);
        for(int r = 0; r < secondlist.size(); r++){
            sum = sum + secondlist.get(r);
        }
        if(sum % 2 != 0){
            result = false;
        }
        return result;
    }

    public static ArrayList<Integer> transformation(Integer[] A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        int k;
        for (int i = 0; i <= A.length - 1; i++) {
            for (int j = 0; j <= A.length - i - 1; j++) {
                k = i + j;
                B.add(maxIzDiappazona(A, j, k));
            }
        }
        return B;
    }

    public static int maxIzDiappazona(Integer[] A, int j, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = j; i <= k; i++){
            result.add(A[i]);
        }
        return Collections.max(result);
    }
}
