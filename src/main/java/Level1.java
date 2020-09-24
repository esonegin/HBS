
import java.util.*;

public class Level1 {
     //v3
    public static String BiggerGreater(String input) {
        mainObject mainObject = new mainObject();

        mainObject.setFirstWord(input);
        mainObject.setAllVariants(allVariants(input));
        mainObject.setNaimenshee(naimenshee(mainObject.getAllVariants()));

        return mainObject.getNaimenshee();
    }

    public static class mainObject{
        private static String firstword;
        ArrayList<String> allVariants = new ArrayList<String>();
        private String naimenshee;

        public static String getFirstWord() {
            return firstword;
        }
        public void setFirstWord(String firstword) {
            this.firstword = firstword;
        }

        public ArrayList<String> getAllVariants() {
            return allVariants;
        }
        public void setAllVariants(ArrayList<String> allVariants) {
            this.allVariants = allVariants;
        }

        public String getNaimenshee() {
            return naimenshee;
        }
        public void setNaimenshee(String naimenshee) {
            this.naimenshee = naimenshee;
        }

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
        if (result.size() <= 1
                || result.get(result.size()-1).equals(mainObject.getFirstWord())) {
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
