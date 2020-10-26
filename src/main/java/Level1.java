import java.util.ArrayList;
import java.util.Collections;

public class Level1 {
//v1
    static boolean TransformTransform(int A[], int N) {
        boolean result = false;
        if( transformation(A) % 2 == 0){
            result = true;
        }
        return result;
    }

    public static int transformation (int A[]){
        int result = 0;
        ArrayList<Integer> B = new ArrayList<Integer>();
        int k;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                k = i + j;
                B.add(maxIzDiappazona(A, j, k));
            }
        }
        for(int l = 0; l < B.size(); l++){
            result = result + B.get(l);
        }
        return result;
    }

    public static int maxIzDiappazona(int A[], int j, int k) {
        int result = 0;
        ArrayList list = new ArrayList<>();
        for (int l = j; l <= k; l++) {
            list.add(A[l]);
        }
        result = (Integer) Collections.max(list);
        return result;
    }


}
