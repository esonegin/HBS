
import java.util.*;

public class Level1 {
     //v2
    public static String BiggerGreater(String input) {

        ArrayList<String> allVariants = allVariants(input);
        return naimenshee(allVariants);
    }

    //Наименьшее из всех лексикографически больших слов
    public static String naimenshee(ArrayList<String> input) {
        Set<String> set = new HashSet<>(input);
        ArrayList<String> result = new ArrayList<>();
        input.clear();
        input.addAll(set);
        result.addAll(set);
        String results = null;
        Collections.sort(result);
        if (result.size() <= 1 || result.get(result.size()-1) == input.get(0)) {
            results = "";
        }
        else if (result.size() == 2){
            results = result.get(result.size()-1);
        }
        else if (result.size() > 2){
            results = result.get(result.size()-2);
        }
        return results;
    }


    public static ArrayList<String> allVariants(String input) {
        java.lang.String[] arr = input.split("");
        ArrayList<java.lang.String> allVariants = new ArrayList<>();
        int count = fuctorial(arr.length);
        int max = arr.length - 1;
        //System.out.println("Вариантов " + count);
        int shift = max;
        java.lang.String t;
        while (count > 0) {
            t = arr[shift];
            arr[shift] = arr[shift - 1];
            arr[shift - 1] = t;
            allVariants.add(add(arr));
            count--;
            if (shift < 2) {
                shift = max;
            } else {
                shift--;
            }
        }
        return allVariants;
    }

    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }

    static String add(String[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
        }
        return result;
    }
}
