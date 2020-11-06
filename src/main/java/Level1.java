import java.util.*;

public class Level1 {

    private static ArrayList<String> allvariants = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println(BalancedParentheses(3));
    }

    //v4
    public static String BalancedParentheses(int N) {
        String result = "";

        recurs(N, 0, "");

        for (int i = 0; i < allvariants.size(); i++) {
            result = result + allvariants.get(i);
        }
        return withoutDubl();
    }

    public static String withoutDubl(){
        Set<String> set = new HashSet<>(allvariants);
        String result2 = "";
        allvariants.clear();
        allvariants.addAll(set);
        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            String element =(String) iterator.next();
            result2 = result2 + " " + element;
        }
        return result2.trim();
    }

    public static void recurs(int kolvopen, int kolvoclosed, String tekushee) {
        if (kolvopen == 0 && kolvoclosed == 0) {
            allvariants.add(tekushee);
        } else {
            if (kolvopen > 0) {
                kolvopen = kolvopen - 1;
                kolvoclosed = kolvoclosed + 1;
                tekushee = tekushee + "(";
                recurs(kolvopen, kolvoclosed, tekushee);
            }
            if (kolvoclosed > 0) {
                kolvoclosed = kolvoclosed - 1;
                tekushee = tekushee + ")";
                recurs(kolvopen, kolvoclosed, tekushee);
            }
        }
    }
}
