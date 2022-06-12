
import java.util.*;

public class MaximumDiscount {

    //Вынес значение первого шага в константу
    static final int FIRSTSTEPVALUE = 2;
    //Вынес размер шага в константу
    static final int STEPSIZE = 3;
    static int size;
    static int[] price;

    public MaximumDiscount(int s, int[] p) {
        this.size = s;
        this.price = p;
    }

    public static int getMaxDiscount() {
        int result = 0;
        if (price.length < STEPSIZE) {
            result = 0;
        } else {
            Integer[] price2  = new Integer[size];
            for (int i = 0; i < size; i++) {
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