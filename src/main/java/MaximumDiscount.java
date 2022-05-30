
import java.util.Arrays;
import java.util.Collections;

public class MaximumDiscount {

    //Вынес значение первого шага в константу
    static final int FIRSTSTEPVALUE = 2;
    //Вынес размер шага в константу
    static final int STEPSIZE = 3;

    public static int MaximumDiscount(int N, int[] price) {
        int result = 0;
        if (price.length < STEPSIZE) {
            result = 0;
        } else {
            Integer[] price2 = new Integer[N];
            for (int i = 0; i < N; i++) {
                price2[i] = price[i];
            }
            Arrays.sort(price2, Collections.reverseOrder());
            for (int i = FIRSTSTEPVALUE; i < price2.length; i += STEPSIZE) {
                result += price2[i];
            }
        }
        return result;
    }
}