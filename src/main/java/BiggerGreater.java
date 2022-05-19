
import java.util.*;

public class BiggerGreater {
    //v4
    public static String BiggerGreater(String input) {
        ValidatedString ValidatedString = new ValidatedString();

        ValidatedString.setFirstWord(input);
        ValidatedString.setAllVariants(allVariants(input));
        ValidatedString.setNaimenshee(naimenshee(ValidatedString.getAllVariants()));

        return ValidatedString.getNaimenshee();
    }

    public static class ValidatedString {
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
        String results = null;
        if (input.size() <= 1
                || input.get(input.size() - 1).equals(ValidatedString.getFirstWord())) {
            results = "";
        } else if (input.size() == 2) {
            results = input.get(input.size() - 1);
        } else if (input.size() > 2) {
            results = input.get(findKeyFirstWord(input) + 1);
        }
        return results;
    }

    public static int findKeyFirstWord(ArrayList<String> allVAriants) {
        return (allVAriants.indexOf(ValidatedString.getFirstWord()));
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

        Set<String> set = new HashSet<>(allVariants);
        ArrayList<String> result = new ArrayList<>();
        allVariants.clear();
        allVariants.addAll(set);
        result.addAll(set);
        Collections.sort(result);
        return result;
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
